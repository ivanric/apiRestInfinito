package com.api.apiRestInfinito.model;

public class Recibo {
	private int idrecib;
	private int idsolicitud;
	private String urlarchivo;
	private String tipo;
	private int idusu;
	private String fecha;
	private int estado;
	public Recibo() {

	}
	public Recibo(int idrecib, int idsolicitud, String urlarchivo, String tipo, int idusu, String fecha, int estado) {

		this.idrecib = idrecib;
		this.idsolicitud = idsolicitud;
		this.urlarchivo = urlarchivo;
		this.tipo = tipo;
		this.idusu = idusu;
		this.fecha = fecha;
		this.estado = estado;
	}
	public int getIdrecib() {
		return idrecib;
	}
	public void setIdrecib(int idrecib) {
		this.idrecib = idrecib;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public String getUrlarchivo() {
		return urlarchivo;
	}
	public void setUrlarchivo(String urlarchivo) {
		this.urlarchivo = urlarchivo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdusu() {
		return idusu;
	}
	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Recibo [idrecib=" + idrecib + ", idsolicitud=" + idsolicitud + ", urlarchivo=" + urlarchivo + ", tipo="
				+ tipo + ", idusu=" + idusu + ", fecha=" + fecha + ", estado=" + estado + "]";
	}
	

}
