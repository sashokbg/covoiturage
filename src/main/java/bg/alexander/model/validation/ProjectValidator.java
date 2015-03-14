package bg.alexander.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import bg.alexander.model.project.Project;

@Component
public class ProjectValidator implements ConstraintValidator<ValidProject,Project>{

	@Override
	public void initialize(ValidProject arg0) {
	}

	@Override
	public boolean isValid(Project project, ConstraintValidatorContext context) {
		if(project.getCode().equals("123"))
			return true;
		
		return false;
	}

}
