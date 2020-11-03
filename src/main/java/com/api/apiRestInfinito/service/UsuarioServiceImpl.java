package com.api.apiRestInfinito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IUsuarioDAO;
import com.api.apiRestInfinito.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	
	@Autowired 
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public Usuario findUserByEmail(String mail) {
		return usuarioDAO.findByEmail(mail);
	}

	@Override
	public Usuario getUsuarioById(int id) {
		return usuarioDAO.getUsuarioById(id);
	}

	@Override
	public Usuario getUsuarioPersonaByIdper(int idusu) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuarioPersonaByIdper(idusu);
	}

	@Override
	public boolean saveUsuario(Usuario user, int idemp) {
		// TODO Auto-generated method stub
		return usuarioDAO.saveUsuario(user, idemp);
	}

	@Override
	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return usuarioDAO.findByEmail(email);
	}

	@Override
	public Usuario getUsuarioPersonaByIdusu(int idusu) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuarioPersonaByIdusu(idusu);
	}

	@Override
	public Usuario getUsuarioPersonaDealerByIdusu(int idper) {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuarioPersonaDealerByIdusu(idper);
	}



}
