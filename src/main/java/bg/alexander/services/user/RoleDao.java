package bg.alexander.services.user;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.Role;
import bg.alexander.services.GenerictDaoInterface;

@SuppressWarnings("unchecked")
@Component
public class RoleDao implements GenerictDaoInterface<Role>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role saveOrUpdate(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> list() {
		return (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

	@Override
	public Role getById(Integer roleId) {
		return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.eq("id", roleId)).uniqueResult();
	}

}
