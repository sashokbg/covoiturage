package bg.alexander.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.services.UserService;

@Controller
@RequestMapping(value="/users")
public class UsersController {
	@Autowired
	private UserService userService;
	private Logger log = Logger.getLogger(UsersController.class);

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String showHomePage(Model model){
		model.addAttribute("usersList",userService.getAllUsers());
		return "users/list";
	}
}
