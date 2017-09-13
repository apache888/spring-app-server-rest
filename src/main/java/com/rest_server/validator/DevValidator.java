package com.rest_server.validator;

import com.rest_server.model.Developer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created on 26.06.2017
 *
 * @author Roman Hayda
 */
public class DevValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Developer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Developer dev = (Developer) target;
        if (dev.getExperience() <= 0) {
            errors.rejectValue("experience", "Developer.experience.invalid");
        }
        if (dev.getSalary() <= 0) {
            errors.rejectValue("salary", "Developer.salary.invalid");
        }
    }
}
