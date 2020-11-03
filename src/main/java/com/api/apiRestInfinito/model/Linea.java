package com.api.apiRestInfinito.model;

public class Linea {
	private int idlinea;
	private String nombre;
	private int estado;
	public Linea() {
	}
	public Linea(int idlinea, String nombre, int estado) {

		this.idlinea = idlinea;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getIdlinea() {
		return idlinea;
	}
	public void setIdlinea(int idlinea) {
		this.idlinea = idlinea;
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
	@Override
	public String toString() {
		return "Linea [idlinea=" + idlinea + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
