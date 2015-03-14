package bg.alexander.model.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import bg.alexander.model.project.Project;

//@Component
public class ProjectValidator2 implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz) ? true : false;
	}

	@Override
	public void validate(Object projectObj, Errors errors) {
		if(errors.hasErrors())
			return;
		Project project = (Project) projectObj;
		if(project.getStart() == null || project.getEnd() == null)
			return;
		if(project.getStart().compareTo(project.getEnd())>0){
			errors.rejectValue("start","project.form.error.start.date");
		}
	}
}
