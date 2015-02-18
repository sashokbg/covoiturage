package bg.alexander.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.User;

@Component
@SuppressWarnings("unchecked")
public class UserDao implements GenerictDaoInterface<User>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> list(){
		List<User> users = (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return users;
	}
	
	public User getById(Integer byId){
		User user = (User)sessionFactory.getCurrentSession().
				createCriteria(User.class).add(Restrictions.eq("id", byId)).uniqueResult();
		
		return user;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
