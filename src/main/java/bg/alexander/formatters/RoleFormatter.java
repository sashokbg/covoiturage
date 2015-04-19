package bg.alexander.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.Role;
import bg.alexander.services.user.UserService;

@Component("roleFormatter")
public class RoleFormatter implements Formatter<Role>{
	@Autowired
	private UserService userService;
	
	@Override
	public String print(Role role, Locale str) {
		return String.valueOf(role.getId());
	}
	
	@Override
	public Role parse(String id, Locale locale) throws ParseException {
		Role role = userService.getRole(Long.valueOf(id));
		return role;
	}
}
