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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bg.alexander.model.user.Role;
import bg.alexander.services.role.RoleService;

@Controller
@RequestMapping("/roles")
public class RolesController {
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("rolesList")
	public List<Role> setRolesList(){
		return roleService.listRoles();
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String manageRoles(@ModelAttribute("role") Role role, Model model){
		return "users/roles";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createRolePost(@Valid @ModelAttribute("role") Role role, BindingResult binding, Model model, RedirectAttributes ra){
		if (binding.hasErrors()) {
			ra.addFlashAttribute("role",role);
			ra.addFlashAttribute("org.springframework.validation.BindingResult.role", binding);
			return "redirect:/roles";
        }
		
		roleService.saveOrUpdate(role);
		return "redirect:/roles";
	}
}
