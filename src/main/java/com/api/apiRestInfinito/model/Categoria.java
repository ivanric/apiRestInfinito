package com.api.apiRestInfinito.model;

public class Categoria {
	private int idcat;
	private String nombre;
	private int estado;
	public Categoria() {

	}
	public Categoria(int idcat, String nombre, int estado) {
		this.idcat = idcat;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
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
		return "Categoria [idcat=" + idcat + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
