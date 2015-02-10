package bg.alexander.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bg.alexander.model.user.User;

@Component
public class UsersService {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<User> getAllUsers(){
		List<User> users = (List<User>)sessionFactory.openSession().createCriteria(User.class).list();
		return users;
	}
}
