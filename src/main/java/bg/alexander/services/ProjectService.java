package bg.alexander.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.alexander.model.user.Project;

@Service
@Transactional
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	
	public Project saveOrUpdate(Project project){
		Project result = projectDao.saveOrUpdate(project);
		return result;
	}

}
