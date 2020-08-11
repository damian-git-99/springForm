package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		
		// Cualquiera de las dos opciones esta bien
		ValidationUtils.rejectIfEmpty(errors, "apellido", "NotEmpty.usuario.apellido");
		
		/*
		if (usuario.getApellido().isEmpty()) {
			errors.rejectValue("apellido", "NotEmpty.usuario.apellido");
		}
		*/
		
	}

}
