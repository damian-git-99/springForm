package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {
	
	// @NoEmpty Regla de validacion: valida que el String no este vacio
	// @Size tamaño que debe tener
	// @Email validar que sea un email
	// message para personalizar el error
	
	@NotEmpty(message = "El nombre no puede estar vacio")
	@Size(min = 3,max = 15)
	private String username;
	
	@NotEmpty
	@Email(message = "Dirección de correo no válida")
	private String email;
	
	@NotEmpty
	private String password;
	
	//@NotEmpty
	private String apellido;
	
	private String id;
	
	@Pattern(regexp = "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
	private String expresion;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpresion() {
		return expresion;
	}
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}
	
	
	
	
}
