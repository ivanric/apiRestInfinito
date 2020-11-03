package com.api.apiRestInfinito.model;

public class PrecioItem {
	private int idprec;
	private int num;
	private double precio;
	private int iditem;
	private int estado;
	
	private Item item;

	public PrecioItem() {

	}

	public PrecioItem(int idprec, int num, double precio, int iditem, int estado, Item item) {
		this.idprec = idprec;
		this.num = num;
		this.precio = precio;
		this.iditem = iditem;
		this.estado = estado;
		this.item = item;
	}

	public int getIdprec() {
		return idprec;
	}

	public void setIdprec(int idprec) {
		this.idprec = idprec;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIditem() {
		return iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "PrecioItem [idprec=" + idprec + ", num=" + num + ", precio=" + precio + ", iditem=" + iditem
				+ ", estado=" + estado + ", item=" + item + "]";
	}
	

}	
