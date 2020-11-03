package com.api.apiRestInfinito.dao;

import java.util.List;


import com.api.apiRestInfinito.model.Modelo;


public interface IModeloDAO {
	public int generarId();
	public List<Modelo> getListModelos();
	public boolean saveModelo(Modelo modelo);
	public Modelo getModeloById(int id);
	public List<Modelo> getListModelosMarcaById(int id);
	
	public Modelo getModeloItemById(int idmod);
}
