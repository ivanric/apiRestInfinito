package com.api.apiRestInfinito.model;

public class Rol {
	private int idrol;
	private String nombre;
	private int estado;
	private int idemp;
	
	public Rol() {
	}

	public Rol(int idrol, String nombre, int estado, int idemp) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
		this.estado = estado;
		this.idemp = idemp;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	@Override
	public String toString() {
		return "Rol [idrol=" + idrol + ", nombre=" + nombre + ", estado=" + estado + ", idemp=" + idemp + "]";
	}
	
	
}
