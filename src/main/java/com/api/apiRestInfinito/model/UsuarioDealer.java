package com.api.apiRestInfinito.model;

public class UsuarioDealer {
	private int idusudel;
	private int idusu;
	private int iddealer;
	private int estado;
	
	private Persona persona;
	private Dealer dealer;
	public UsuarioDealer() {

	}
	public UsuarioDealer(int idusudel, int idusu, int iddealer, int estado, Persona persona, Dealer dealer) {
		super();
		this.idusudel = idusudel;
		this.idusu = idusu;
		this.iddealer = iddealer;
		this.estado = estado;
		this.persona = persona;
		this.dealer = dealer;
	}
	public int getIdusudel() {
		return idusudel;
	}
	public void setIdusudel(int idusudel) {
		this.idusudel = idusudel;
	}
	public int getIdusu() {
		return idusu;
	}
	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}
	public int getIddealer() {
		return iddealer;
	}
	public void setIddealer(int iddealer) {
		this.iddealer = iddealer;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	@Override
	public String toString() {
		return "UsuarioDealer [idusudel=" + idusudel + ", idusu=" + idusu + ", iddealer=" + iddealer + ", estado="
				+ estado + ", persona=" + persona + ", dealer=" + dealer + "]";
	}
	
}
