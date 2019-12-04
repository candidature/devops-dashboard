package com.broadcom.devopsd.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadcom.devopsd.dao.ToolDao;
import com.broadcom.devopsd.entity.Announcement;
import com.broadcom.devopsd.entity.Criticality;
import com.broadcom.devopsd.entity.Domain;
import com.broadcom.devopsd.entity.Kind;
import com.broadcom.devopsd.entity.Tier;
import com.broadcom.devopsd.entity.Tool;
import com.broadcom.devopsd.entity.ToolInstance;
import com.broadcom.devopsd.service.DevopsService;

@Controller
@RequestMapping("/devops")
public class DevopsController {
	@Autowired
	private DevopsService devopsService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    //dateFormat.setLenient(false);

	    DateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
	    
	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(newDate, true));
	}
	
	@RequestMapping("/tools")
	public String listTools(Model model) {
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		List<Announcement> announcements = devopsService.listActiveAnnouncements();
		model.addAttribute("globalAnnouncement", announcements);
		
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
		
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
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
	    
	    List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
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
	
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
	
	    ToolInstance toolInstance = new ToolInstance();
	    model.addAttribute("toolInstance", toolInstance);
	    
	    
	    EnumSet<Domain> domains = EnumSet.allOf(Domain.class);
		model.addAttribute("domains", domains);
	    
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
	    
	    List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		
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
	    
	    List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		
		return "list-instances";
		
	}
	
	
	
	
	
	@GetMapping(value="/instances")
	public String ListInstanceAllInstances(Model model) {
		
		List<ToolInstance> toolInstances = this.devopsService.getInstances();
	    model.addAttribute("toolInstances", toolInstances);
	    System.out.println("Got list of toolInstances " + toolInstances);
	    
	    List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		
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
	
	/* DISPLAY GLOBAL ANNOUNCEMENT FORM */
	@RequestMapping("/announcement")
	public String showCreateAnnouncementForm(Model model) {
		Announcement announcement = new Announcement();
		model.addAttribute("announcement", announcement);
		
		EnumSet<Kind> kinds = EnumSet.allOf(Kind.class);
		model.addAttribute("kinds", kinds);
		
		
		EnumSet<Criticality> criticalities = EnumSet.allOf(Criticality.class);
		model.addAttribute("criticalities", criticalities);
		
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		return "announcement-new-form";
	}
	
	/* Save the GLOBAL Announcement FORM */
	@PostMapping("/announcement")
	public String saveCreateAnnouncementForm(@ModelAttribute("Announcement") Announcement announcement) {
		devopsService.saveAnnouncement(announcement);
		return "redirect:/devops/announcements/";
		
	}
	
	/* EDIT an announcement form but save using same method as of new creation remember hidden id field does magic. */
	@GetMapping("/announcement/{announcementId}")
	public String editAnnouncementForm(@PathVariable("announcementId") int announcementId, Model model) {
		//devopsService.saveAnnouncement(announcement);
		
		Announcement announcement = devopsService.getAnnouncement(announcementId);
		model.addAttribute("announcement", announcement);
		
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		return "announcement-new-form";
	}
	
	
	/* List active announcement */
	
	@GetMapping("/announcements")
	public String listAnnouncementsForm(Model model) {
		List<Announcement> announcements = devopsService.listAllAnnouncements();
		model.addAttribute("announcements", announcements);
		
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		
		return "announcement-global-list";
	}
	
	/* EDIT an announcement form but save using same method as of new creation remember hidden id field does magic. */
	@GetMapping("/announcement/{announcementId}/delete")
	public String deleteAnnouncement(@PathVariable("announcementId") int announcementId) {
		//devopsService.saveAnnouncement(announcement);
		
		devopsService.deleteAnnouncement(announcementId);
		

		return "redirect:/devops/announcements/";
	}
	
	
	
	/* DISPLAY ANNOUNCEMENT FORM for a TOOL */
	@GetMapping("/announcement/tool/{toolId}")
	public String showCreateAnnouncementFormForTool(@PathVariable("toolId") int toolId, Model model) {
		
		Tool tool = devopsService.getTool(toolId);
		model.addAttribute("tool", tool);
		
		
		Announcement announcement = new Announcement();
		
		//announcement.setTool(tool);
		model.addAttribute("announcement", announcement);
		
		EnumSet<Kind> kinds = EnumSet.allOf(Kind.class);
		model.addAttribute("kinds", kinds);
		
		List<Tool> tools = this.devopsService.getTools();
		model.addAttribute("tools", tools);
		
		
		EnumSet<Criticality> criticalities = EnumSet.allOf(Criticality.class);
		model.addAttribute("criticalities", criticalities);
		
		
		
		return "announcement-tool-new-form";
	}
	

	/* Save the TOOL Announcement FORM */
	@PostMapping("/announcement/tool/{toolId}")
	public String saveCreateToolAnnouncementForm(@PathVariable("toolId") int toolId, @ModelAttribute("Announcement") Announcement announcement) {
		Tool tool = devopsService.getTool(toolId);
		System.out.println("Tool is " + tool);
		announcement.setTool(tool);
		devopsService.saveAnnouncement(announcement);
		return "redirect:/devops/announcements/";
		
	}
	
	
	
}
