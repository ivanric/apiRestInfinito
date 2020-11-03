package com.api.apiRestInfinito.service;

import com.api.apiRestInfinito.model.Usuario;

public interface IUsuarioService {
	public Usuario findUserByEmail(String mail);
	
	public boolean saveUsuario(Usuario user,int idemp);
	public Usuario findByEmail(String email);//findUserByEmail es la misma
	
	public Usuario getUsuarioById(int id);
	public Usuario getUsuarioPersonaByIdper(int idper);
	public Usuario getUsuarioPersonaByIdusu(int idusu);
	public Usuario getUsuarioPersonaDealerByIdusu(int idper);
}
