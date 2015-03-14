package bg.alexander.controller;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.model.project.Project;
import bg.alexander.services.project.ProjectService;
import bg.alexander.services.user.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectsController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createProjectGet(Model model){
		model.addAttribute("users",userService.list());
		model.addAttribute(new Project());
		return "projects/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createProjectPost(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult, Model model){
		model.addAttribute("users",userService.list());
		if(bindingResult.hasErrors()){
			return "projects/create";
		}
		projectService.saveOrUpdate(project);
		
		return "redirect:/projects/list";
	}
	
	@RequestMapping(value="list")
	public String listProjects(Model model){
		model.addAttribute("projects",projectService.list());
		return "projects/list";
	}
}
