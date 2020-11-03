package com.api.apiRestInfinito.service;

import java.util.Map;

import com.api.apiRestInfinito.model.Persona;

public interface IPersonaService {
	public Map<String,Object> savePersona(Persona persona);
	public Persona getPersonaByid(int id);
	public Persona getPersonaUsuarioByid(int idusu);
	public Persona getPersonaUsuarioDealerByIdusu(int idusu);
}
