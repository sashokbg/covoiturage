package bg.alexander.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bg.alexander.services.UsersService;

@Controller
public class FrontPageController {
	@Autowired
	private UsersService userService;
	private Logger log = Logger.getLogger(FrontPageController.class);

	public FrontPageController() {
		log.info("INITED ME");
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView showHomePage(){
		log.info("called");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(userService.getAllUsers());
		return modelAndView;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView show(){
		log.info("called");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(userService.getAllUsers());
		return modelAndView;
	}
}
