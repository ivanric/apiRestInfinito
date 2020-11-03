package com.api.apiRestInfinito.model;

import java.util.List;

public class Item {
	private int iditem;
	private int idmod;
	private int idcolor;
	
	private int idcat;
	private int idlinea;
	private int idusu;
	private int idemp;
	private int disponible;
	
	private Modelo modelo;
	private Color color;
	private	Categoria categoria;
	private Linea linea;
	private Usuario usuario;
	private Empresa empresa;
	
	private List<PrecioItem> precioItemList;

	public Item() {
	}

	public Item(int iditem, int idmod, int idcolor, int idcat, int idlinea, int idusu, int idemp, int disponible,
			Modelo modelo, Color color, Categoria categoria, Linea linea, Usuario usuario, Empresa empresa,
			List<PrecioItem> precioItemList) {

		this.iditem = iditem;
		this.idmod = idmod;
		this.idcolor = idcolor;
		this.idcat = idcat;
		this.idlinea = idlinea;
		this.idusu = idusu;
		this.idemp = idemp;
		this.disponible = disponible;
		this.modelo = modelo;
		this.color = color;
		this.categoria = categoria;
		this.linea = linea;
		this.usuario = usuario;
		this.empresa = empresa;
		this.precioItemList = precioItemList;
	}

	public int getIditem() {
		return iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public int getIdmod() {
		return idmod;
	}

	public void setIdmod(int idmod) {
		this.idmod = idmod;
	}

	public int getIdcolor() {
		return idcolor;
	}

	public void setIdcolor(int idcolor) {
		this.idcolor = idcolor;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public int getIdlinea() {
		return idlinea;
	}

	public void setIdlinea(int idlinea) {
		this.idlinea = idlinea;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<PrecioItem> getPrecioItemList() {
		return precioItemList;
	}

	public void setPrecioItemList(List<PrecioItem> precioItemList) {
		this.precioItemList = precioItemList;
	}

	@Override
	public String toString() {
		return "Item [iditem=" + iditem + ", idmod=" + idmod + ", idcolor=" + idcolor + ", idcat=" + idcat
				+ ", idlinea=" + idlinea + ", idusu=" + idusu + ", idemp=" + idemp + ", disponible=" + disponible
				+ ", modelo=" + modelo + ", color=" + color + ", categoria=" + categoria + ", linea=" + linea
				+ ", usuario=" + usuario + ", empresa=" + empresa + ", precioItemList=" + precioItemList + "]";
	}

	
}
