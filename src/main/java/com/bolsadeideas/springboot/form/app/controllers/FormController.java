package com.bolsadeideas.springboot.form.app.controllers;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.IPaisService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private IPaisService paisService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);

		// Recordatorio: es mas simple usar la anotacion @DateTimeFormat(pattern =
		// "yyyy-MM-dd") en usuario
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "username", new NombreMayusculaEditor());
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Mexico", "España", "Chile", "Argentina", "Colombia");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<>();
		paises.put("es", "España");
		paises.put("mx", "Mexico");
		paises.put("cl", "Chile");
		paises.put("ar", "Argentina");
		paises.put("co", "Colombia");
		return paises;
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		// Como el usuario no tiene definidos los datos
		usuario.setApellido("Galvan");
		usuario.setId("123.456.789-K");
		usuario.setHabilitar(true);
		usuario.setPais(new Pais(1,"mx","Mexico"));
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Form");
		return "form";
	}
	
	

	@PostMapping("/form")
	public String processForm(@Valid Usuario usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Form Result");
			return "form";
		}

		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario",required = false) Usuario usuario, Model model,SessionStatus status) {
		if (usuario==null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Form Result");
		status.setComplete();
		return "results";
	}

}

