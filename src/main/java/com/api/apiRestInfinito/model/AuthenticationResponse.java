package com.api.apiRestInfinito.model;

import java.util.List;

public class AuthenticationResponse {//para dar una respuesta del token

	private String token;
	private int idusu;
	private String mail;
	private String username;
	private String fotoUrl;
	private String creado;
	private boolean activo;
	List<Rol> roles;
	

	public AuthenticationResponse() {
	}


	public AuthenticationResponse(String token, int idusu, String mail, String username, String fotoUrl, String creado,
			boolean activo, List<Rol> roles) {
		super();
		this.token = token;
		this.idusu = idusu;
		this.mail = mail;
		this.username = username;
		this.fotoUrl = fotoUrl;
		this.creado = creado;
		this.activo = activo;
		this.roles = roles;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public int getIdusu() {
		return idusu;
	}


	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFotoUrl() {
		return fotoUrl;
	}


	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}


	public String getCreado() {
		return creado;
	}


	public void setCreado(String creado) {
		this.creado = creado;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public List<Rol> getRoles() {
		return roles;
	}


	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "AuthenticationResponse [token=" + token + ", idusu=" + idusu + ", mail=" + mail + ", username="
				+ username + ", fotoUrl=" + fotoUrl + ", creado=" + creado + ", activo=" + activo + ", roles=" + roles
				+ "]";
	}


	
	
}