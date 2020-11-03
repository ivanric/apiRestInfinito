package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ICategoriaDAO;
import com.api.apiRestInfinito.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	ICategoriaDAO CategoriaDAO;
	
	@Override
	public List<Categoria> getListCategorias() {
		// TODO Auto-generated method stub
		return CategoriaDAO.getListCategorias();
	}

	@Override
	public boolean saveCategoria(Categoria Categoria) {
		// TODO Auto-generated method stub
		return CategoriaDAO.saveCategoria(Categoria);
	}

	@Override
	public Categoria getCategoriaById(int id) {
		// TODO Auto-generated method stub
		return CategoriaDAO.getCategoriaById(id);
	}

	@Override
	public Categoria getCategoriaItemById(int id) {
		// TODO Auto-generated method stub
		return CategoriaDAO.getCategoriaItemById(id);
	}


}
