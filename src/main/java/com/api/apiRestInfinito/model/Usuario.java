package com.api.apiRestInfinito.model;

import java.util.List;

public class Usuario {
	private int idusu;
	private String username;
	private String mail;
	private String password;
	private String tipo;
	private int estado;
	private int idper;
	
	private List<Rol> listRoles;

	public Usuario() {
	}

	public Usuario(int idusu, String username, String mail, String password, String tipo, int estado, int idper, List<Rol> listRoles) {
		this.idusu = idusu;
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.tipo = tipo;
		this.estado = estado;
		this.idper = idper;
		this.listRoles = listRoles;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getIdper() {
		return idper;
	}

	public void setIdper(int idper) {
		this.idper = idper;
	}

	public List<Rol> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Rol> listRoles) {
		this.listRoles = listRoles;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"idusu=" + idusu +
				", username='" + username + '\'' +
				", mail='" + mail + '\'' +
				", password='" + password + '\'' +
				", tipo='" + tipo + '\'' +
				", estado=" + estado +
				", idper=" + idper +
				", listRoles=" + listRoles +
				'}';
	}
}
