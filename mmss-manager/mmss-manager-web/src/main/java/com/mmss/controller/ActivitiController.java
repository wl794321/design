package com.mmss.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mmss.service.activiti.WorkflowProcessDefinitionService;
import com.mmss.service.activiti.WorkflowTraceService;
import com.mmss.workflowutils.Page;
import com.mmss.workflowutils.PageUtil;
import com.mmss.workflowutils.WorkflowUtils;


/**
 * 流程管理控制器
 *
 * @author HenryYan
 */
@Controller
@RequestMapping(value = "/workflow")
public class ActivitiController {
	    protected Logger logger = LoggerFactory.getLogger(getClass());

	    protected WorkflowProcessDefinitionService workflowProcessDefinitionService;

	    protected RepositoryService repositoryService;

	    protected RuntimeService runtimeService;

	    protected TaskService taskService;

	    protected WorkflowTraceService traceService;

	    @Autowired
	    ManagementService managementService;

	    protected static Map<String, ProcessDefinition> PROCESS_DEFINITION_CACHE = new HashMap<String, ProcessDefinition>();

	    @Autowired
	    ProcessEngineFactoryBean processEngine;

	    @Autowired
	    ProcessEngineConfiguration processEngineConfiguration;

	    /**
	     * 流程定义列表
	     *
	     * @return
	     */
	    @RequestMapping(value = "/process-list")
	    public ModelAndView processList(HttpServletRequest request) {
	        ModelAndView mav = new ModelAndView("workflow/process-list");

	    /*
	     * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
	     */
	        List<Object[]> objects = new ArrayList<Object[]>();

	        Page<Object[]> page = new Page<Object[]>(PageUtil.PAGE_SIZE);
	        int[] pageParams = PageUtil.init(page, request);

	        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByDeploymentId().desc();
	        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pageParams[0], pageParams[1]);
	        for (ProcessDefinition processDefinition : processDefinitionList) {
	            String deploymentId = processDefinition.getDeploymentId();
	            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
	            objects.add(new Object[]{processDefinition, deployment});
	        }

	        page.setTotalCount(processDefinitionQuery.count());
	        page.setResult(objects);
	        mav.addObject("page", page);

	        return mav;
	    }

	    /**
	     * 部署全部流程
	     *
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/redeploy/all")
	    public String redeployAll(@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir) throws Exception {
	        workflowProcessDefinitionService.deployAllFromClasspath(exportDir);
	        return "redirect:/workflow/process-list";
	    }

	    /**
	     * 读取资源，通过部署ID
	     *
	     * @param processDefinitionId 流程定义
	     * @param resourceType        资源类型(xml|image)
	     * @throws Exception
	     */
	    @RequestMapping(value = "/resource/read")
	    public void loadByDeployment(@RequestParam("processDefinitionId") String processDefinitionId, @RequestParam("resourceType") String resourceType,
	                                 HttpServletResponse response) throws Exception {
	        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
	        String resourceName = "";
	        if (resourceType.equals("image")) {
	            resourceName = processDefinition.getDiagramResourceName();
	        } else if (resourceType.equals("xml")) {
	            resourceName = processDefinition.getResourceName();
	        }
	        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
	        byte[] b = new byte[1024];
	        int len = -1;
	        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
	            response.getOutputStream().write(b, 0, len);
	        }
	    }

	    /**
	     * 读取资源，通过流程ID
	     *
	     * @param resourceType      资源类型(xml|image)
	     * @param processInstanceId 流程实例ID
	     * @param response
	     * @throws Exception
	     */
	    @RequestMapping(value = "/resource/process-instance")
	    public void loadByProcessInstance(@RequestParam("type") String resourceType, @RequestParam("pid") String processInstanceId, HttpServletResponse response)
	            throws Exception {
	        InputStream resourceAsStream = null;
	        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
	        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstance.getProcessDefinitionId())
	                .singleResult();

	        String resourceName = "";
	        if (resourceType.equals("image")) {
	            resourceName = processDefinition.getDiagramResourceName();
	        } else if (resourceType.equals("xml")) {
	            resourceName = processDefinition.getResourceName();
	        }
	        resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
	        byte[] b = new byte[1024];
	        int len = -1;
	        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
	            response.getOutputStream().write(b, 0, len);
	        }
	    }

	    /**
	     * 删除部署的流程，级联删除流程实例
	     *
	     * @param deploymentId 流程部署ID
	     */
	    @RequestMapping(value = "/process/delete")
	    public String delete(@RequestParam("deploymentId") String deploymentId) {
	        repositoryService.deleteDeployment(deploymentId, true);
	        return "redirect:/workflow/process-list";
	    }

	    /**
	     * 输出跟踪流程信息
	     *
	     * @param processInstanceId
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/process/trace")
	    @ResponseBody
	    public List<Map<String, Object>> traceProcess(@RequestParam("pid") String processInstanceId) throws Exception {
	        List<Map<String, Object>> activityInfos = traceService.traceProcess(processInstanceId);
	        return activityInfos;
	    }

	    /**
	     * 读取带跟踪的图片
	     */
	    @RequestMapping(value = "/process/trace/auto/{executionId}")
	    public void readResource(@PathVariable("executionId") String executionId, HttpServletResponse response)
	            throws Exception {
	        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId).singleResult();
	        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
	        List<String> activeActivityIds = runtimeService.getActiveActivityIds(executionId);
	        // 不使用spring请使用下面的两行代码
//	    ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl) ProcessEngines.getDefaultProcessEngine();
//	    Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

	        // 使用spring注入引擎请使用下面的这行代码
	        processEngineConfiguration = processEngine.getProcessEngineConfiguration();
	        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

	        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
	        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds);

	        // 输出资源内容到相应对象
	        byte[] b = new byte[1024];
	        int len;
	        while ((len = imageStream.read(b, 0, 1024)) != -1) {
	            response.getOutputStream().write(b, 0, len);
	        }
	    }

	    @RequestMapping(value = "/deploy")
	    public String deploy(@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir, @RequestParam(value = "file", required = false) MultipartFile file) {

	        String fileName = file.getOriginalFilename();

	        try {
	            InputStream fileInputStream = file.getInputStream();
	            Deployment deployment = null;

	            String extension = FilenameUtils.getExtension(fileName);
	            if (extension.equals("zip") || extension.equals("bar")) {
	                ZipInputStream zip = new ZipInputStream(fileInputStream);
	                deployment = repositoryService.createDeployment().addZipInputStream(zip).deploy();
	            } else {
	                deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
	            }

	            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();

	            for (ProcessDefinition processDefinition : list) {
	                WorkflowUtils.exportDiagramToFile(repositoryService, processDefinition, exportDir);
	            }

	        } catch (Exception e) {
	            logger.error("error on deploy process, because of file input stream", e);
	        }

	        return "redirect:/workflow/process-list";
	    }

	    /**
	     * 挂起、激活流程实例
	     */
	    @RequestMapping(value = "processdefinition/update/{state}/{processDefinitionId}")
	    public String updateState(@PathVariable("state") String state, @PathVariable("processDefinitionId") String processDefinitionId,
	                              RedirectAttributes redirectAttributes) {
	        if (state.equals("active")) {
	            redirectAttributes.addFlashAttribute("message", "已激活ID为[" + processDefinitionId + "]的流程定义。");
	            repositoryService.activateProcessDefinitionById(processDefinitionId, true, null);
	        } else if (state.equals("suspend")) {
	            repositoryService.suspendProcessDefinitionById(processDefinitionId, true, null);
	            redirectAttributes.addFlashAttribute("message", "已挂起ID为[" + processDefinitionId + "]的流程定义。");
	        }
	        return "redirect:/workflow/process-list";
	    }

	    /**
	     * 导出图片文件到硬盘
	     *
	     * @return
	     */
	    @RequestMapping(value = "export/diagrams")
	    @ResponseBody
	    public List<String> exportDiagrams(@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir) throws IOException {
	        List<String> files = new ArrayList<String>();
	        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();

	        for (ProcessDefinition processDefinition : list) {
	            files.add(WorkflowUtils.exportDiagramToFile(repositoryService, processDefinition, exportDir));
	        }

	        return files;
	    }

	

	    @RequestMapping(value = "bpmn/model/{processDefinitionId}")
	    @ResponseBody
	    public BpmnModel queryBpmnModel(@PathVariable("processDefinitionId") String processDefinitionId) {
	        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
	        return bpmnModel;
	    }

	    @Autowired
	    public void setWorkflowProcessDefinitionService(WorkflowProcessDefinitionService workflowProcessDefinitionService) {
	        this.workflowProcessDefinitionService = workflowProcessDefinitionService;
	    }

	    @Autowired
	    public void setRepositoryService(RepositoryService repositoryService) {
	        this.repositoryService = repositoryService;
	    }

	    @Autowired
	    public void setRuntimeService(RuntimeService runtimeService) {
	        this.runtimeService = runtimeService;
	    }

	    @Autowired
	    public void setTraceService(WorkflowTraceService traceService) {
	        this.traceService = traceService;
	    }

	    @Autowired
	    public void setTaskService(TaskService taskService) {
	        this.taskService = taskService;
	    }
}
