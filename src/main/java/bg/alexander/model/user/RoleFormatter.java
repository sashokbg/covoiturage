package bg.alexander.model.user;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import bg.alexander.services.UserService;

@Component("roleFormatter")
public class RoleFormatter implements Formatter<Role>{
	@Autowired
	private UserService userService;
	
	@Override
	public String print(Role role, Locale str) {
		return String.valueOf(role);
	}
	@Override
	public Role parse(String id, Locale locale) throws ParseException {
		return userService.getRole(Integer.valueOf(id));
	}
}
