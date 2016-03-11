package bg.alexander.services.role;

import java.util.List;

import org.hibernate.Criteria;
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
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public Role getById(Long roleId) {
		return (Role) sessionFactory.getCurrentSession().createCriteria(Role.class).add(Restrictions.eq("id", roleId)).uniqueResult();
	}

	@Override
	public List<Role> list() {
		return (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}

}
