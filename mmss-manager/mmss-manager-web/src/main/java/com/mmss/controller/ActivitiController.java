package com.mmss.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mmss.service.activiti.WorkflowProcessDefinitionService;
import com.mmss.service.activiti.WorkflowTraceService;


@Controller
@RequestMapping(value="/workflow")
public class ActivitiController {
	/* protected Logger logger = LoggerFactory.getLogger(getClass());
	 	@Resource
	    protected WorkflowProcessDefinitionService workflowProcessDefinitionService;
	 	@Resource
	    protected RepositoryService repositoryService;
	 	@Resource
	    protected RuntimeService runtimeService;
	 	@Resource
	    protected TaskService taskService;
	 	@Resource
	    protected WorkflowTraceService traceService;
	    @Resource
	    ManagementService managementService;
	    @Resource
	    ProcessEngineFactoryBean processEngine;
	    @Resource
	    ProcessEngineConfiguration processEngineConfiguration;

	@RequestMapping(value="/process-list")
	public ModelAndView processList(){
		ModelAndView mav = new ModelAndView("flow/process-list");
		List<Object> objects = new ArrayList<>();
		mav.addObject("objects", objects);
		return mav;
	}
	@RequestMapping(value="/deploy/all")
	public String redeployAll(@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir) throws Exception{
		
			workflowProcessDefinitionService.deployAllFromClasspath(exportDir);
	
	        return "redirect:/workflow/process-list";
	}
	*//**
     * 读取资源，通过部署ID
     *
     * @param processDefinitionId 流程定义
     * @param resourceType        资源类型(xml|image)
     * @throws Exception
     *//*
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
    *//**
     * 读取资源，通过流程ID
     *
     * @param resourceType      资源类型(xml|image)
     * @param processInstanceId 流程实例ID
     * @param response
     * @throws Exception
     *//*
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

    *//**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     *//*
    @RequestMapping(value = "/process/delete")
    public String delete(@RequestParam("deploymentId") String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
        return "redirect:/workflow/process-list";
    }*/
    
}
