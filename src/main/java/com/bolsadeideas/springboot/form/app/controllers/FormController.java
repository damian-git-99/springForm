package com.bolsadeideas.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		//Como el usuario no tiene definidos los datos
		usuario.setApellido("Galvan");
		usuario.setId("123.456.789-K");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Form");
		return "form";
	}


	@PostMapping("/form")
	public String processForm(@Valid  Usuario usuario, BindingResult result , Model model,
			@RequestParam(name = "username", defaultValue = "") String username, SessionStatus status) {
		validador.validate(usuario, result);
		model.addAttribute("titulo", "Form Result");
		if (result.hasErrors()) {
			//model.addAttribute("usuario", usuario); esta linea no es necesaria por que spring se la pasa automaticamente
			// y le pasa la variable con nombre igual que la clase en minuscula
			//ejemplo: Usuario spring pasa la variable como : usuario
			return "form";
		}
		
		
		
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "results";
	}

}
