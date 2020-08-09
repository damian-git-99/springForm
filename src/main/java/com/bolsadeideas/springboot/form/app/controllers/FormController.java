package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		//Como el usuario no tiene definidos los datos
		//Spring lo toma como una cadena vacia
		model.addAttribute("user", usuario);
		model.addAttribute("titulo", "Form");
		return "form";
	}

	@PostMapping("/form")
	public String processForm(@Valid Usuario user, BindingResult result , Model model,
			@RequestParam(name = "username", defaultValue = "") String username,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "email", defaultValue = "") String email) {
		
		model.addAttribute("titulo", "Form Result");
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo "
						.concat(err.getField())
						.concat(" ")
						.concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			model.addAttribute("user", user);
			return "form";
		}
		
		
		model.addAttribute("user", user);
		return "results";
	}

}
