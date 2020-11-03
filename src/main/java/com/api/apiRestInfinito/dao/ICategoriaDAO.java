package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Categoria;
import com.api.apiRestInfinito.model.Color;

public interface ICategoriaDAO {
	public int generarId();
	public List<Categoria> getListCategorias();
	public boolean saveCategoria(Categoria categoria);
	public Categoria getCategoriaById(int id);
	public Categoria getCategoriaItemById(int id);

}
