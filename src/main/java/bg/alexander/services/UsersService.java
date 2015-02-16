package bg.alexander.services;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bg.alexander.model.user.User;

@Component
@SuppressWarnings("unchecked")
public class UsersService {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<User> getAllUsers(){
		List<User> users = (List<User>)sessionFactory.openSession().createCriteria(User.class).list();
		getAllUsersBornBefore(null);
		return users;
	}
	
	public List<User> getAllUsersBornBefore(Date date){
		List<User> users = (List<User>)sessionFactory.openSession().
				createCriteria(User.class).add(Restrictions.lt("birthDay", new Date(1985,0,0)))
				.list();
		return users;
	}
}
