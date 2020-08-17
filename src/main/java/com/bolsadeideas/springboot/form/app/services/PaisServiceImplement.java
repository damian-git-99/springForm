package com.bolsadeideas.springboot.form.app.services;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;


@Service
public class PaisServiceImplement implements IPaisService {
	
	private List<Pais> lista;

	public PaisServiceImplement() {
		lista = Arrays.asList(
			new Pais(1,"mx","Mexico"),
			new Pais(2,"es","España"),
			new Pais(3,"cl","Chile"),
			new Pais(4,"ar","Argentina"),
			new Pais(5,"co","Colombia"),
			new Pais(6,"pe","Perú"));
		}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultadoPais = null;
		for (Pais pais : lista) {
			if(pais.getId() == id) { 
				resultadoPais = pais;
				break;
			}
		}
		return resultadoPais;
	}

}
