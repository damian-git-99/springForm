package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bolsadeideas.springboot.form.app.validation.IdentificadorRegex;

public class Usuario {
	
	// @NoEmpty Regla de validacion: valida que el String no este vacio y calcular el lenght de una lista o arreglo
	// @Size tamaño que debe tener
	// @Email validar que sea un email
	// message para personalizar el error
	
	//@NotEmpty(message = "El nombre no puede estar vacio")
	//@Size(min = 3,max = 15)
	//@NotBlank
	@IdentificadorRegex(message = "El campo esta vacio")
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
	
	@NotNull
	@Min(1)
	@Max(1000)
	private Integer edad;
	
	@NotNull
	@Past
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Valid
	private Pais pais;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	
	
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Boolean getHabilitar() {
		return habilitar;
	}
	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getEdad() {
		return edad;
	}
	
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
	
	
}
