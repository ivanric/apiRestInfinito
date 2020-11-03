package com.api.apiRestInfinito.service;

import java.util.List;
import com.api.apiRestInfinito.model.Marca;



public interface IMarcaService {
	public List<Marca> getListMarcas();
	public boolean saveMarca(Marca marca);
	public Marca getMarcaById(int id);
	public Marca getMarcaModeloById(int id);
}
