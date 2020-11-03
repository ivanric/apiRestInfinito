package com.api.apiRestInfinito.model;

import java.util.List;

public class Dealer {
	private int iddealer;
	private String nombre_empresa;
	private String propietario;
	private String num_telefono;
	private String latitud;
	private String longitud;
	private String tipo;
	private int estado;
	private int pertencedealer;
	
	private List<Dealer> dealersList;
	
	public Dealer() {
	}

	public Dealer(int iddealer, String nombre_empresa, String propietario, String num_telefono, String latitud,
			String longitud, String tipo, int estado, int pertencedealer, List<Dealer> dealersList) {

		this.iddealer = iddealer;
		this.nombre_empresa = nombre_empresa;
		this.propietario = propietario;
		this.num_telefono = num_telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
		this.estado = estado;
		this.pertencedealer = pertencedealer;
		this.dealersList = dealersList;
	}

	public int getIddealer() {
		return iddealer;
	}

	public void setIddealer(int iddealer) {
		this.iddealer = iddealer;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getNum_telefono() {
		return num_telefono;
	}

	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getPertencedealer() {
		return pertencedealer;
	}

	public void setPertencedealer(int pertencedealer) {
		this.pertencedealer = pertencedealer;
	}

	public List<Dealer> getDealersList() {
		return dealersList;
	}

	public void setDealersList(List<Dealer> dealersList) {
		this.dealersList = dealersList;
	}

	@Override
	public String toString() {
		return "Dealer [iddealer=" + iddealer + ", nombre_empresa=" + nombre_empresa + ", propietario=" + propietario
				+ ", num_telefono=" + num_telefono + ", latitud=" + latitud + ", longitud=" + longitud + ", tipo="
				+ tipo + ", estado=" + estado + ", pertencedealer=" + pertencedealer + ", dealersList=" + dealersList
				+ "]";
	}

	
}
