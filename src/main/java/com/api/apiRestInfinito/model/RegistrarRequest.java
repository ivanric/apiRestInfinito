package com.api.apiRestInfinito.model;

public class RegistrarRequest {
	private Persona persona;
	private Integer idemp;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RegistrarRequest() {
	}

	/**
	 *
	 * @param persona
	 * @param idemp
	 */
	public RegistrarRequest(Persona persona, Integer idemp) {
		super();
		this.persona = persona;
		this.idemp = idemp;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getIdemp() {
		return idemp;
	}

	public void setIdemp(Integer idemp) {
		this.idemp = idemp;
	}

	@Override
	public String toString() {
		return "RegistrarRequest [persona=" + persona + ", idemp=" + idemp + "]";
	}
	
}
