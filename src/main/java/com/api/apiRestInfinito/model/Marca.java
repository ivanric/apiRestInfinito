package com.api.apiRestInfinito.model;

import java.util.List;

public class Marca {
	private int idmarc;
	private String nombre;
	private int estado;
	
	List<Modelo> modelosList;
	
	public Marca() {
	}

	public Marca(int idmarc, String nombre, int estado, List<Modelo> modelosList) {
		this.idmarc = idmarc;
		this.nombre = nombre;
		this.estado = estado;
		this.modelosList = modelosList;
	}

	public int getIdmarc() {
		return idmarc;
	}

	public void setIdmarc(int idmarc) {
		this.idmarc = idmarc;
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

	public List<Modelo> getModelosList() {
		return modelosList;
	}

	public void setModelosList(List<Modelo> modelosList) {
		this.modelosList = modelosList;
	}

	@Override
	public String toString() {
		return "Marca [idmarc=" + idmarc + ", nombre=" + nombre + ", estado=" + estado + ", modelosList=" + modelosList
				+ "]";
	}

}
