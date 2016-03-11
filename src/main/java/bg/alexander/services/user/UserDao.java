package bg.alexander.services.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.User;
import bg.alexander.services.GenerictDaoInterface;

@Component
@SuppressWarnings("unchecked")
public class UserDao implements GenerictDaoInterface<User>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> list(){
		List<User> users = (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}
	
	public User getById(Long byId){
		User user = (User)sessionFactory.getCurrentSession().
				createCriteria(User.class)
				.add(Restrictions.eq("id", byId)).uniqueResult();
		
		return user;
	}
	
	@Override
	public User saveOrUpdate(User entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(getById(id));
	}
}
