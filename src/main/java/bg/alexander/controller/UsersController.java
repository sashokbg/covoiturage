package bg.alexander.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.model.user.Gender;
import bg.alexander.model.user.User;
import bg.alexander.services.user.UserService;

@Controller
@RequestMapping(value="/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String showHomePage(Model model){
		model.addAttribute("usersList",userService.getAllUsers());
		return "users/list";
	}
	
	@RequestMapping(value="create",method=RequestMethod.GET)
	public String createUserGet(Model model){
		model.addAttribute("rolesList",userService.listRoles());
		model.addAttribute("gendersList",Gender.values());
		User emptyUser = new User();
		emptyUser.setRoles(userService.listRoles());
		model.addAttribute("user",emptyUser);
		return "users/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createUserPost(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "/users/create";
        }
		
		userService.saveOrUpdate(user);
		return "redirect:/users/list";
	}
}
