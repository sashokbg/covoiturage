package bg.alexander.services.project;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.alexander.model.project.Project;
import bg.alexander.services.GenerictDaoInterface;

@Component
@SuppressWarnings("unchecked")
public class ProjectDao implements GenerictDaoInterface<Project> {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Project saveOrUpdate(Project project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);
		return project;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Project> list() {
		return sessionFactory.getCurrentSession().
				createCriteria(Project.class).
				setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).
				addOrder(Order.desc("id")).
				list();
	}

	@Override
	public Project getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
