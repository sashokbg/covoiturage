package bg.alexander.controller;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.model.user.Project;
import bg.alexander.model.user.User;
import bg.alexander.services.ProjectService;
import bg.alexander.services.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createProjectGet(){
		return "project/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createProjectPost(@ModelAttribute("project") Project project, Integer creatorId, String assignedUsersIds){
		User creator = userService.getUser(creatorId);
		project.setCreator(creator);
		
		//get assigned users
		Set<User> assignedUsersSet = new HashSet<User>();
		for(String userId : assignedUsersIds.split(",")){
			assignedUsersSet.add(userService.getUser(Integer.valueOf(userId)));
		}
		
		project.setAssignedUsers(assignedUsersSet);
		
		projectService.saveOrUpdate(project);
		
		return "project/create";
	}
}
