package com.api.apiRestInfinito.model;

public class Color {
	private int idcolor;
	private String nombre;
	private int estado;
	public Color() {

	}
	public Color(int idcolor, String nombre, int estado) {
		this.idcolor = idcolor;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getIdcolor() {
		return idcolor;
	}
	public void setIdcolor(int idcolor) {
		this.idcolor = idcolor;
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
		return "Color [idcolor=" + idcolor + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
