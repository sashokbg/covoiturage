package bg.alexander.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.alexander.model.user.Project;

@Component
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
