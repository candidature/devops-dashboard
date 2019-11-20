package com.broadcom.devopsd.controller;

import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadcom.devopsd.dao.ToolDao;
import com.broadcom.devopsd.entity.Announcement;
import com.broadcom.devopsd.entity.Tier;
import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;
import com.broadcom.devopsd.service.DevopsService;

@Controller
@RequestMapping("/devops")
public class DevopsController {
	@Autowired
	private DevopsService devopsService;
	
	@RequestMapping("/tools")
	public String listTools(Model model) {
		List<Tool> tools = this.devopsService.getTools();
		
		model.addAttribute("tools", tools);
		return "list-tools";
	}
	
	
	@GetMapping("/tools/{tier}")
	public String listToolsByTier(@PathVariable("tier") String tier, Model model) {
		List<Tool> tools = this.devopsService.getToolsByTier(tier);
		
		model.addAttribute("tools", tools);
		model.addAttribute("tier", tier);
		return "list-tools";
	}
	

	
	@RequestMapping("/showFormForAddNewApplication")
	public String showFormForAddNewApplication(Model model) {
		Tool tool = new Tool();
		model.addAttribute("tool", tool);
		EnumSet<Tier> tiers = EnumSet.allOf(Tier.class);
		model.addAttribute("tiers", tiers);
		return "tool-form";
	}
	
	@PostMapping("/saveNewApplication")
	public String SaveNewApplication(@ModelAttribute("tool") Tool tool) {
		devopsService.saveTool(tool);
		return "redirect:/devops/tools";
	}
	
	
	// EDIT TOOL
	
	//http://localhost:8080/DEVOPS-DASH1/devops/tools/showFormForToolUpdate?toolId=1
	@GetMapping("/showFormForToolUpdate")
	public String ShowFormForToolUpdate(@RequestParam("toolId") int toolId, Model model) {
		System.out.println("For debugging...");
		Tool tool = this.devopsService.getTool(toolId);
	    model.addAttribute("tool", tool);
	    model.addAttribute("kind", "EDIT");
	    
		return "tool-form";
		
	}
	
	/* DELETE a TOOL*/
	//http://localhost:8080/DEVOPS-DASH1/devops/tool/1
	@GetMapping(value="/tool/{toolId}")
	public String DeleteTool(@PathVariable("toolId") int toolId, Model model) {
		
		
		System.out.println("For debugging...DELETEING TOOL " + Integer.toString(toolId));
		this.devopsService.deleteTool(toolId);
		
		return "redirect:/devops/tools";
		
	}
	
	/* Used for displaying form for adding new instance only */
	
	@GetMapping(value="/tool/{toolId}/instance")
	public String GetAddNewInstanceForm2(@PathVariable("toolId") int toolId, Model model) {
		
		
		System.out.println("For debugging..." + Integer.toString(toolId));
		Tool tool = this.devopsService.getTool(toolId);
	    model.addAttribute("tool", tool);
	    
	    ToolInstance toolInstance = new ToolInstance();
	    model.addAttribute("toolInstance", toolInstance);
	    
	    
	    
	    
		return "instance-form";
		
	}
	
//WARNING: Resolved [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
//Field error in object 'toolInstance' on field 'toolId': rejected value [11]; codes [typeMismatch.toolInstance.toolId,typeMismatch.toolId,typeMismatch.com.broadcom.devopsd.entity.Tool,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [toolInstance.toolId,toolId]; arguments []; default message [toolId]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId': no matching editors or conversion strategy found]]
	/* Used for saving submitted updated for only */
//WARNING: Resolved [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
//	Field error in object 'toolInstance' on field 'toolId': rejected value [2]; codes [typeMismatch.toolInstance.toolId,typeMismatch.toolId,typeMismatch.com.broadcom.devopsd.entity.Tool,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [toolInstance.toolId,toolId]; arguments []; default message [toolId]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId': no matching editors or conversion strategy found]]
//Field error in object 'toolInstance' on field 'toolId': rejected value [11]; codes [typeMismatch.toolInstance.toolId,typeMismatch.toolId,typeMismatch.com.broadcom.devopsd.entity.Tool,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [toolInstance.toolId,toolId]; arguments []; default message [toolId]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId': no matching editors or conversion strategy found]]

	/* For new instance Add only*/
	@PostMapping(value="/tool/{tool_id}/instance")
	public String AddNewInstanceFormSubmit(@PathVariable("tool_id") int tool_id, 
			@ModelAttribute("toolInstance") ToolInstance toolInstance, Model model) {
		
		Tool tool = this.devopsService.getTool(tool_id);
		toolInstance.setTool(tool);
		
		System.out.println("Inside AddNewInstanceFormSubmit!!");
		this.devopsService.saveToolInstance(toolInstance);
		
		return "redirect:/devops/tool/{tool_id}/instances";
		
		
	}
	
	
	/*
	 * 
	 * <c:url var="updateLink" value="/devops/tool/${toolId}/instance/${toolInstance.id}">

			</c:url>
			
			
			
			<c:url var="delInsrance" value="/devops/tool/${toolId}/delinstance/${toolInstance.id}">
	*/		
	
	/* Used for displaying form for EDIT instance only */
			
	//devops/tool/${toolId}/instance/${toolInstance.id}"
	@GetMapping(value="/tool/{toolId}/instance/{instanceId}")
	public String EditInstanceForm(@PathVariable("toolId") int toolId, @PathVariable("instanceId") int instanceId, Model model) {
		System.out.println("For debugging..." + Integer.toString(toolId));
		
		
		ToolInstance toolInstance = this.devopsService.getInstance(instanceId);
	    model.addAttribute("toolInstance", toolInstance);
	    
	    Tool tool = this.devopsService.getTool(toolId);
	    model.addAttribute("tool", tool);
	    
	    
		return "instance-form";
		
	}
	
	//http://localhost:8080/DEVOPS-DASH1/devops/tool/2/instance/1
	/*
	
	@PostMapping(value="/tool/{toolId}/instance")
	public String EditInstanceForm2(@PathVariable("toolId") int toolId, 
			@ModelAttribute("toolInstance") ToolInstance toolInstance) {
		System.out.println("For debugging..." + Integer.toString(toolId));
	

		return "list-instances";
		
	}
	*/
	
	
	//WARNING: Resolved [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
	//Field error in object 'toolInstance' on field 'toolId': rejected value [1]; codes [typeMismatch.toolInstance.toolId,typeMismatch.toolId,typeMismatch.com.broadcom.devopsd.entity.Tool,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [toolInstance.toolId,toolId]; arguments []; default message [toolId]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId': no matching editors or conversion strategy found]]
	@GetMapping(value="/tool/{toolId}/instances")
	public String ListInstanceForm(@PathVariable("toolId") int toolId, Model model) {
		System.out.println("For debugging..." + Integer.toString(toolId));
		List<ToolInstance> toolInstances = this.devopsService.getInstances(toolId);
	    model.addAttribute("toolInstances", toolInstances);
	    model.addAttribute("toolId", toolId);
		return "list-instances";
		
	}
	
	
	
	
	
	@GetMapping(value="/tools/instances")
	public String ListInstanceAllInstances(Model model) {
		
		List<ToolInstance> toolInstances = this.devopsService.getInstances();
	    model.addAttribute("toolInstances", toolInstances);
	    
		return "list-all-instances";
		
	}
	
	
	
	/* DELETE a TOOL - INSTANCE*/
	//http://localhost:8080/DEVOPS-DASH1/devops/tool/1
	@GetMapping(value="/tool/{toolId}/instance/{instanceId}/delete")

	public String DeleteToolInstance(@PathVariable("toolId") int toolId,@PathVariable("instanceId") int instanceId, Model model) {
		
		
		//System.out.println("For debugging...DELETEING TOOL " + Integer.toString(instanceId));
		this.devopsService.deleteToolInstance(instanceId);
		
		return "redirect:/devops/tool/{toolId}/instances/";
		
	}
	
	
	
	
	/* Below code is related to announcement */
	
	@RequestMapping("/announcement")
	public String showCreateAnnouncementForm(Model model) {
		Announcement announcement = new Announcement();
		model.addAttribute("tool", announcement);
		
		return "announcement-new-form";
	}
	
	
	
	
}
