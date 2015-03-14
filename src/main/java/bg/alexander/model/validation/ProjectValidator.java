package bg.alexander.model.validation;

import java.util.Calendar;

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
		if(project.getStart() != null && project.getEnd() != null){
			if(project.getStart().compareTo(project.getEnd())>0){
				context.disableDefaultConstraintViolation();
				context
					.buildConstraintViolationWithTemplate("{project.form.error.start.date}")
					.addPropertyNode("start" ).addConstraintViolation();
				return false;
			}
			
			//TODO finish date validation for current date
			if (project.getEnd().compareTo(Calendar.getInstance().getTime())<0){
				
	        }
		}
		
		return true;
	}
}
