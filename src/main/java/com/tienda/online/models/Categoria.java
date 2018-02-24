package com.tienda.online.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	private String id;
	
	private String nombre;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Categoria(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
