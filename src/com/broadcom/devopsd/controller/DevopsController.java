package com.broadcom.devopsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadcom.devopsd.dao.ToolDao;
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
	
	
	@RequestMapping("/showFormForAddNewApplication")
	public String showFormForAddNewApplication(Model model) {
		Tool tool = new Tool();
		model.addAttribute("tool", tool);
		
		return "tool-form";
	}
	
	@PostMapping("/saveNewApplication")
	public String SaveNewApplication(@ModelAttribute("tool") Tool tool) {
		
		devopsService.saveTool(tool);
		return "redirect:/devops/tools";
	}
	//http://localhost:8080/DEVOPS-DASH1/devops/tools/showFormForToolUpdate?toolId=1
	@GetMapping("/showFormForToolUpdate")
	public String ShowFormForToolUpdate(@RequestParam("toolId") int toolId, Model model) {
		System.out.println("For debugging...");
		Tool tool = this.devopsService.getTool(toolId);
	    model.addAttribute("tool", tool);
		return "tool-form";
		
	}
	
	// - /devops/tool/${tool.id}/instance
	
	@GetMapping(value="/tool/{toolId}/instance")
	public String AddNewInstanceForm(@PathVariable("toolId") int toolId, Model model) {
		System.out.println("For debugging..." + Integer.toString(toolId));
		Tool tool = this.devopsService.getTool(toolId);
	    model.addAttribute("tool", tool);
	    
	    ToolInstance toolInstance = new ToolInstance();
	    model.addAttribute("toolInstance", toolInstance);
		return "instance-form";
		
	}
	
	@PostMapping(value="/tool/{id}/instance")
	public String AddNewInstanceFormSubmit(@PathVariable("id") String id, @ModelAttribute("toolInstance") ToolInstance toolInstance) {
		System.out.println("For debugging..." + id);
		Tool tool = this.devopsService.getTool(Integer.valueOf(id));
		System.out.println(toolInstance);
		tool.add(toolInstance);
		
		devopsService.saveInstance(toolInstance);
		
		
		return "redirect:/devops/tools";
		
	}
//WARNING: Resolved [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
//Field error in object 'toolInstance' on field 'toolId': rejected value [1]; codes [typeMismatch.toolInstance.toolId,typeMismatch.toolId,typeMismatch.com.broadcom.devopsd.entity.Tool,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [toolInstance.toolId,toolId]; arguments []; default message [toolId]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type 'com.broadcom.devopsd.entity.Tool' for property 'toolId': no matching editors or conversion strategy found]]

	
}
