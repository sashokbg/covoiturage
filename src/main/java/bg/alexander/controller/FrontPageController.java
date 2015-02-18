package bg.alexander.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.alexander.services.UserService;

@Controller
public class FrontPageController {
	@Autowired
	private UserService userService;
	private Logger log = Logger.getLogger(FrontPageController.class);

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showHomePage(Model model){
		log.info("called 1");
		model.addAttribute("usersList",userService.getAllUsers());
		return "home";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String show(Model model){
		log.info("called 2");
		model.addAttribute(userService.getAllUsers());
		return "home";
	}
}
