package bg.alexander.model.user;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import bg.alexander.services.user.UserService;

@Component("userFormatter")
public class UserFormatter implements Formatter<User>{
	@Autowired
	private UserService userService;
	
	@Override
	public String print(User user, Locale locale) {
		return user.toString();
	}

	@Override
	public User parse(String userId, Locale locale) throws ParseException {
		User user = userService.getUser(Long.valueOf(userId)); 
//		if(user==null){
//			throw new ParseException("No such user found : id ["+userId+"]", 0);
//		}
		return user;
	}
}
