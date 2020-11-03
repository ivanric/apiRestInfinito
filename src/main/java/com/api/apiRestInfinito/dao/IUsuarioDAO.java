package com.api.apiRestInfinito.dao;

import com.api.apiRestInfinito.model.Usuario;

public interface IUsuarioDAO {
	public int generarIdUser();
	public int generarIdUserEmp();
	public boolean saveUsuario(Usuario user,int idemp);
	public Usuario findByEmail(String email);
	
	public Usuario getUsuarioById(int id);
	public Usuario getUsuarioPersonaByIdper(int idper);
	public Usuario getUsuarioPersonaByIdusu(int idusu);
	public Usuario getUsuarioPersonaDealerByIdusu(int idper);
}
