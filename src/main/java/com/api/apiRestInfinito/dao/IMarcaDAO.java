package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Marca;

public interface IMarcaDAO {
	public int generarId();
	public List<Marca> getListMarcas();
	public boolean saveMarca(Marca marca);
	public Marca getMarcaById(int id);
	public Marca getMarcaModeloById(int id);
	

}
