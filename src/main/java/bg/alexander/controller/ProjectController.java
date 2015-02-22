package bg.alexander.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.model.user.Project;
import bg.alexander.model.user.User;
import bg.alexander.services.ProjectService;
import bg.alexander.services.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createProjectGet(Model model){
		model.addAttribute("users",userService.list());
		return "projects/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createProjectPost(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult, Model model, Integer creatorId, String assignedUsersIds){
		model.addAttribute("users",userService.list());
		if (bindingResult.hasErrors()) {
			return "/projects/create";
        }
		User creator = userService.getUser(creatorId);
		project.setCreator(creator);
		
		//get assigned users
		Set<User> assignedUsersSet = new HashSet<User>();
		for(String userId : assignedUsersIds.split(",")){
			assignedUsersSet.add(userService.getUser(Integer.valueOf(userId)));
		}
		
		project.setAssignedUsers(assignedUsersSet);
		projectService.saveOrUpdate(project);
		
		return "redirect:/projects/list";
	}
	
	@RequestMapping(value="list")
	public String listProjects(Model model){
		model.addAttribute("projects",projectService.list());
		return "projects/list";
	}
}
