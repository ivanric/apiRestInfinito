package com.api.apiRestInfinito.model;

public class CategoriaSolicitud {
	private int idsoltcat;
	private int idcat;//idcatalogo
	private int iditem;
	private double sub_total;
	private int idsolicitud;
	private int cantidad;
	
	private Catalogo catalogo;
	private Item item;
	private SolicitudItem solicitudItem;
	
	
	public CategoriaSolicitud() {

	}
	public CategoriaSolicitud(int idsoltcat, int idcat, int iditem, double sub_total, int idsolicitud, int cantidad,
			Catalogo catalogo, Item item, SolicitudItem solicitudItem) {

		this.idsoltcat = idsoltcat;
		this.idcat = idcat;
		this.iditem = iditem;
		this.sub_total = sub_total;
		this.idsolicitud = idsolicitud;
		this.cantidad = cantidad;
		this.catalogo = catalogo;
		this.item = item;
		this.solicitudItem = solicitudItem;
	}
	public int getIdsoltcat() {
		return idsoltcat;
	}
	public void setIdsoltcat(int idsoltcat) {
		this.idsoltcat = idsoltcat;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	public int getIditem() {
		return iditem;
	}
	public void setIditem(int iditem) {
		this.iditem = iditem;
	}
	public double getSub_total() {
		return sub_total;
	}
	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public SolicitudItem getSolicitudItem() {
		return solicitudItem;
	}
	public void setSolicitudItem(SolicitudItem solicitudItem) {
		this.solicitudItem = solicitudItem;
	}
	@Override
	public String toString() {
		return "CategoriaSolicitud [idsoltcat=" + idsoltcat + ", idcat=" + idcat + ", iditem=" + iditem + ", sub_total="
				+ sub_total + ", idsolicitud=" + idsolicitud + ", cantidad=" + cantidad + ", catalogo=" + catalogo
				+ ", item=" + item + ", solicitudItem=" + solicitudItem + "]";
	}
	
	
}
