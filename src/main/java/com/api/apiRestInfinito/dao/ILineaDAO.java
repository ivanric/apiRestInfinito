package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Linea;

public interface ILineaDAO {
	public int generarId();
	public List<Linea> getListLineas();
	public boolean saveLinea(Linea linea);
	public Linea getLineaById(int id);
	
	public Linea getLineaItemById(int id);
	

}
