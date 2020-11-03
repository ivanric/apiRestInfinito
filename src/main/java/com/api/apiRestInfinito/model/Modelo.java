package com.api.apiRestInfinito.model;

public class Modelo {
	private int idmod;
	private String nombre;
	private int estado;
	private int idmarc;
	private int anho;
	private Marca marca;
	
	public Modelo() {
		
	}
	public Modelo(int idmod, String nombre, int estado, int idmarc, int anho, Marca marca) {

		this.idmod = idmod;
		this.nombre = nombre;
		this.estado = estado;
		this.idmarc = idmarc;
		this.anho = anho;
		this.marca = marca;
	}
	public int getIdmod() {
		return idmod;
	}
	public void setIdmod(int idmod) {
		this.idmod = idmod;
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
	public int getIdmarc() {
		return idmarc;
	}
	public void setIdmarc(int idmarc) {
		this.idmarc = idmarc;
	}
	public int getAnho() {
		return anho;
	}
	public void setAnho(int anho) {
		this.anho = anho;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Modelo [idmod=" + idmod + ", nombre=" + nombre + ", estado=" + estado + ", idmarc=" + idmarc + ", anho="
				+ anho + ", marca=" + marca + "]";
	}
	
	
}
