package com.api.apiRestInfinito.model;

public class DetalleSolicitudItem {
	private int iddetsoltitem;
	private int idsoltcat;
	private int cantidad;
	private int idart;
	
	private double precioitemdel;
	private double sub_total;
	private int pagado;
	public DetalleSolicitudItem() {
	}
	public DetalleSolicitudItem(int iddetsoltitem, int idsoltcat, int cantidad, int idart, double precioitemdel,
			double sub_total, int pagado) {

		this.iddetsoltitem = iddetsoltitem;
		this.idsoltcat = idsoltcat;
		this.cantidad = cantidad;
		this.idart = idart;
		this.precioitemdel = precioitemdel;
		this.sub_total = sub_total;
		this.pagado = pagado;
	}
	public int getIddetsoltitem() {
		return iddetsoltitem;
	}
	public void setIddetsoltitem(int iddetsoltitem) {
		this.iddetsoltitem = iddetsoltitem;
	}
	public int getIdsoltcat() {
		return idsoltcat;
	}
	public void setIdsoltcat(int idsoltcat) {
		this.idsoltcat = idsoltcat;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdart() {
		return idart;
	}
	public void setIdart(int idart) {
		this.idart = idart;
	}
	public double getPrecioitemdel() {
		return precioitemdel;
	}
	public void setPrecioitemdel(double precioitemdel) {
		this.precioitemdel = precioitemdel;
	}
	public double getSub_total() {
		return sub_total;
	}
	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	public int getPagado() {
		return pagado;
	}
	public void setPagado(int pagado) {
		this.pagado = pagado;
	}
	@Override
	public String toString() {
		return "DetalleSolicitudItem [iddetsoltitem=" + iddetsoltitem + ", idsoltcat=" + idsoltcat + ", cantidad="
				+ cantidad + ", idart=" + idart + ", precioitemdel=" + precioitemdel + ", sub_total=" + sub_total
				+ ", pagado=" + pagado + "]";
	}
	
	
	
	

}
