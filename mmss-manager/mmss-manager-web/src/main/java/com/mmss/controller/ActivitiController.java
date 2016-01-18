package com.mmss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mmss.service.activiti.WorkflowProcessDefinitionService;
import com.mmss.service.activiti.WorkflowTraceService;


@Controller
@RequestMapping(value="/workflow")
public class ActivitiController {
	 protected Logger logger = LoggerFactory.getLogger(getClass());
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

	@RequestMapping(value="/process-list")
	public ModelAndView processList(){
		ModelAndView mav = new ModelAndView("/flow/process-list");
		List<Object> objects = new ArrayList<>();
		mav.addObject("objects", objects);
		return mav;
	}
	@RequestMapping(value="/deploy/all")
	public String redeployAll(@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir) throws Exception{
		
			workflowProcessDefinitionService.deployAllFromClasspath(exportDir);
	
	        return "redirect:/workflow/process-list";
	}
}
