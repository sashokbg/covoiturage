package bg.alexander.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.model.user.Gender;
import bg.alexander.model.user.Role;
import bg.alexander.model.user.User;
import bg.alexander.services.role.RoleService;
import bg.alexander.services.user.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("page")
	public String module() {
		return "users";
	}

	@RequestMapping(value={"","list"},method=RequestMethod.GET)
	public String showHomePage(Model model){
		model.addAttribute("usersList",userService.getAllUsers());
		return "users/list";
	}
	
	@ModelAttribute("rolesList")
	public List<Role> setRolesList(){
		return roleService.listRoles();
	}
	
	@RequestMapping(value="create",method=RequestMethod.GET)
	public String createUserGet(Model model){
		model.addAttribute("gendersList",Gender.values());
		model.addAttribute(new User());
		return "users/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createUserPost(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			model.addAttribute("user",user);
			return "users/create";
        }
		
		userService.saveOrUpdate(user);
		return "redirect:/users/list";
	}
}
