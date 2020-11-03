package com.api.apiRestInfinito.model;

public class Catalogo {
	private int idcat;
	private int iddealer;
	private int idprec;
	private int asignado;
	private Dealer dealer;
	private PrecioItem precioItem;
	
	public Catalogo() {

	}

	public Catalogo(int idcat, int iddealer, int idprec, int asignado, Dealer dealer, PrecioItem precioItem) {
		super();
		this.idcat = idcat;
		this.iddealer = iddealer;
		this.idprec = idprec;
		this.asignado = asignado;
		this.dealer = dealer;
		this.precioItem = precioItem;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public int getIddealer() {
		return iddealer;
	}

	public void setIddealer(int iddealer) {
		this.iddealer = iddealer;
	}

	public int getIdprec() {
		return idprec;
	}

	public void setIdprec(int idprec) {
		this.idprec = idprec;
	}

	public int getAsignado() {
		return asignado;
	}

	public void setAsignado(int asignado) {
		this.asignado = asignado;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public PrecioItem getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(PrecioItem precioItem) {
		this.precioItem = precioItem;
	}

	@Override
	public String toString() {
		return "Catalogo [idcat=" + idcat + ", iddealer=" + iddealer + ", idprec=" + idprec + ", asignado=" + asignado
				+ ", dealer=" + dealer + ", precioItem=" + precioItem + "]";
	}

}
