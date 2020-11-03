package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Categoria;



public interface ICategoriaService {
	public List<Categoria> getListCategorias();
	public boolean saveCategoria(Categoria categoria);
	public Categoria getCategoriaById(int id);
	public Categoria getCategoriaItemById(int id);
	
}
