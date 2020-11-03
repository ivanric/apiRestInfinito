package com.api.apiRestInfinito.model;

import java.util.Date;

public class Empresa {
	private int idemp;
	private String nit;
	private String nombre;
	private String direccion;
	private String telefono;

	private int estado;
	private int idprov;
	private int num_afiliados;
	private String codigo_emp;
	private String propietario;
	
	private int idcat;
	
	private Date fechainiciocontrato;
	private Date fechafincontrato;
	
	public Empresa() {
	}

	public Empresa(int idemp, String nit, String nombre, String direccion, String telefono, int estado, int idprov,
			int num_afiliados, String codigo_emp, String propietario, int idcat, Date fechainiciocontrato,
			Date fechafincontrato) {
		super();
		this.idemp = idemp;
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
		this.idprov = idprov;
		this.num_afiliados = num_afiliados;
		this.codigo_emp = codigo_emp;
		this.propietario = propietario;
		this.idcat = idcat;
		this.fechainiciocontrato = fechainiciocontrato;
		this.fechafincontrato = fechafincontrato;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdprov() {
		return idprov;
	}

	public void setIdprov(int idprov) {
		this.idprov = idprov;
	}

	public int getNum_afiliados() {
		return num_afiliados;
	}

	public void setNum_afiliados(int num_afiliados) {
		this.num_afiliados = num_afiliados;
	}

	public String getCodigo_emp() {
		return codigo_emp;
	}

	public void setCodigo_emp(String codigo_emp) {
		this.codigo_emp = codigo_emp;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public Date getFechainiciocontrato() {
		return fechainiciocontrato;
	}

	public void setFechainiciocontrato(Date fechainiciocontrato) {
		this.fechainiciocontrato = fechainiciocontrato;
	}

	public Date getFechafincontrato() {
		return fechafincontrato;
	}

	public void setFechafincontrato(Date fechafincontrato) {
		this.fechafincontrato = fechafincontrato;
	}

	@Override
	public String toString() {
		return "Empresa [idemp=" + idemp + ", nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", estado=" + estado + ", idprov=" + idprov + ", num_afiliados="
				+ num_afiliados + ", codigo_emp=" + codigo_emp + ", propietario=" + propietario + ", idcat=" + idcat
				+ ", fechainiciocontrato=" + fechainiciocontrato + ", fechafincontrato=" + fechafincontrato + "]";
	}
	
	
}
