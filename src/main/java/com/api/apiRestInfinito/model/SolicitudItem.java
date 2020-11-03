package com.api.apiRestInfinito.model;

import java.util.List;

public class SolicitudItem {

	private int idsolicitud;
	private int idusudelsolicitante;
	private int idusudelreceptor;
	
	private String metodopago;
	private String fecha;
	private long num_solicitud;
	private double totaldolares;
	private int cantidaditems;
	private int aprovado;
	
	private double totalbolivianos;
	private int solicitudcerrada;
	private int cantidaditemspagados;
	
	private List<CategoriaSolicitud> categoriasSolicitudItemList;
	private List<Recibo> recibosSolicitudItemList;
	
	private UsuarioDealer UsuarioDealerSolicitante;
	private UsuarioDealer UsuarioDealerRecetor;
	public SolicitudItem() {

	}
	public SolicitudItem(int idsolicitud, int idusudelsolicitante, int idusudelreceptor, String metodopago,
			String fecha, long num_solicitud, double totaldolares, int cantidaditems, int aprovado,
			double totalbolivianos, int solicitudcerrada, int cantidaditemspagados,
			List<CategoriaSolicitud> categoriasSolicitudItemList, List<Recibo> recibosSolicitudItemList,
			UsuarioDealer usuarioDealerSolicitante, UsuarioDealer usuarioDealerRecetor) {

		this.idsolicitud = idsolicitud;
		this.idusudelsolicitante = idusudelsolicitante;
		this.idusudelreceptor = idusudelreceptor;
		this.metodopago = metodopago;
		this.fecha = fecha;
		this.num_solicitud = num_solicitud;
		this.totaldolares = totaldolares;
		this.cantidaditems = cantidaditems;
		this.aprovado = aprovado;
		this.totalbolivianos = totalbolivianos;
		this.solicitudcerrada = solicitudcerrada;
		this.cantidaditemspagados = cantidaditemspagados;
		this.categoriasSolicitudItemList = categoriasSolicitudItemList;
		this.recibosSolicitudItemList = recibosSolicitudItemList;
		UsuarioDealerSolicitante = usuarioDealerSolicitante;
		UsuarioDealerRecetor = usuarioDealerRecetor;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public int getIdusudelsolicitante() {
		return idusudelsolicitante;
	}
	public void setIdusudelsolicitante(int idusudelsolicitante) {
		this.idusudelsolicitante = idusudelsolicitante;
	}
	public int getIdusudelreceptor() {
		return idusudelreceptor;
	}
	public void setIdusudelreceptor(int idusudelreceptor) {
		this.idusudelreceptor = idusudelreceptor;
	}
	public String getMetodopago() {
		return metodopago;
	}
	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public long getNum_solicitud() {
		return num_solicitud;
	}
	public void setNum_solicitud(long num_solicitud) {
		this.num_solicitud = num_solicitud;
	}
	public double getTotaldolares() {
		return totaldolares;
	}
	public void setTotaldolares(double totaldolares) {
		this.totaldolares = totaldolares;
	}
	public int getCantidaditems() {
		return cantidaditems;
	}
	public void setCantidaditems(int cantidaditems) {
		this.cantidaditems = cantidaditems;
	}
	public int getAprovado() {
		return aprovado;
	}
	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}
	public double getTotalbolivianos() {
		return totalbolivianos;
	}
	public void setTotalbolivianos(double totalbolivianos) {
		this.totalbolivianos = totalbolivianos;
	}
	public int getSolicitudcerrada() {
		return solicitudcerrada;
	}
	public void setSolicitudcerrada(int solicitudcerrada) {
		this.solicitudcerrada = solicitudcerrada;
	}
	public int getCantidaditemspagados() {
		return cantidaditemspagados;
	}
	public void setCantidaditemspagados(int cantidaditemspagados) {
		this.cantidaditemspagados = cantidaditemspagados;
	}
	public List<CategoriaSolicitud> getCategoriasSolicitudItemList() {
		return categoriasSolicitudItemList;
	}
	public void setCategoriasSolicitudItemList(List<CategoriaSolicitud> categoriasSolicitudItemList) {
		this.categoriasSolicitudItemList = categoriasSolicitudItemList;
	}
	public List<Recibo> getRecibosSolicitudItemList() {
		return recibosSolicitudItemList;
	}
	public void setRecibosSolicitudItemList(List<Recibo> recibosSolicitudItemList) {
		this.recibosSolicitudItemList = recibosSolicitudItemList;
	}
	public UsuarioDealer getUsuarioDealerSolicitante() {
		return UsuarioDealerSolicitante;
	}
	public void setUsuarioDealerSolicitante(UsuarioDealer usuarioDealerSolicitante) {
		UsuarioDealerSolicitante = usuarioDealerSolicitante;
	}
	public UsuarioDealer getUsuarioDealerRecetor() {
		return UsuarioDealerRecetor;
	}
	public void setUsuarioDealerRecetor(UsuarioDealer usuarioDealerRecetor) {
		UsuarioDealerRecetor = usuarioDealerRecetor;
	}
	@Override
	public String toString() {
		return "SolicitudItem [idsolicitud=" + idsolicitud + ", idusudelsolicitante=" + idusudelsolicitante
				+ ", idusudelreceptor=" + idusudelreceptor + ", metodopago=" + metodopago + ", fecha=" + fecha
				+ ", num_solicitud=" + num_solicitud + ", totaldolares=" + totaldolares + ", cantidaditems="
				+ cantidaditems + ", aprovado=" + aprovado + ", totalbolivianos=" + totalbolivianos
				+ ", solicitudcerrada=" + solicitudcerrada + ", cantidaditemspagados=" + cantidaditemspagados
				+ ", categoriasSolicitudItemList=" + categoriasSolicitudItemList + ", recibosSolicitudItemList="
				+ recibosSolicitudItemList + ", UsuarioDealerSolicitante=" + UsuarioDealerSolicitante
				+ ", UsuarioDealerRecetor=" + UsuarioDealerRecetor + "]";
	}

}
