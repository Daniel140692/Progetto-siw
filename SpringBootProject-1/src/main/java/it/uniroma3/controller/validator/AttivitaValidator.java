package it.uniroma3.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Attivita;

@Component
public class AttivitaValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		return Attivita.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		

	}
}