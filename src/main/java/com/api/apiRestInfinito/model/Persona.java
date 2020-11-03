package com.api.apiRestInfinito.model;

public class Persona {
	private int idper;
	private String ci;
	private String nombres,apellidos,telefono,tipo;
	private int estado;
	
	private Usuario usuario;
	
	public Persona() {
	
	}

	public Persona(int idper, String ci, String nombres, String apellidos, String telefono, String tipo, int estado,
			Usuario usuario) {
		super();
		this.idper = idper;
		this.ci = ci;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.tipo = tipo;
		this.estado = estado;
		this.usuario = usuario;
	}

	public int getIdper() {
		return idper;
	}

	public void setIdper(int idper) {
		this.idper = idper;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Persona [idper=" + idper + ", ci=" + ci + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", tipo=" + tipo + ", estado=" + estado + ", usuario=" + usuario + "]";
	}
	
}
