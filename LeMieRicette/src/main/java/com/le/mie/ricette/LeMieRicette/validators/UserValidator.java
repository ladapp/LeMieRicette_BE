package com.le.mie.ricette.LeMieRicette.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.le.mie.ricette.LeMieRicette.entities.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "La password deve essere lunga almeno 8 caratteri!");
        }
	}

}
