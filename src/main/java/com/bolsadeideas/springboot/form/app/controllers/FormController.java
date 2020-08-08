package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Form");
		return "form";
	}
	
	@PostMapping("/form")
	public String processForm(Model model, 
			@RequestParam(name = "username", defaultValue = "") String username,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "email", defaultValue = "") String email) {
			
			model.addAttribute("titulo", "Form Result");
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			model.addAttribute("email", email);
			
			return "results";
	}
	
	
}
