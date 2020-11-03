package com.api.apiRestInfinito.dao;

import java.util.Map;

import com.api.apiRestInfinito.model.Persona;
import com.api.apiRestInfinito.model.Usuario;

public interface IPersonaDAO {
	public int generarIdPer();
	public Map<String,Object> savePersona(Persona persona);
	public Persona getPersonaByid(int id);
	public Persona getPersonaUsuarioByid(int idusu);
	public Persona getPersonaUsuarioDealerByIdusu(int idusu);
}
