package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.UsuarioDealer;

public interface IUsuarioDealerDAO {
	public int generarId();
	public List<UsuarioDealer> getListUsuarioDealers();
	public boolean saveUsuarioDealer(UsuarioDealer UsuarioDealer);
	public UsuarioDealer getUsuarioDealerById(int id);
	

}
