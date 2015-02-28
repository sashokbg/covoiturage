package bg.alexander.services.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.alexander.model.project.Project;

@Service
@Transactional
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> list(){
		List<Project> result = projectDao.list();
		return result;
	}
	
	public Project saveOrUpdate(Project project){
		Project result = projectDao.saveOrUpdate(project);
		return result;
	}

}
