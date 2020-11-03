package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ICatalogoDAO;
import com.api.apiRestInfinito.model.Catalogo;

@Service
public class CatalogoServiceImpl implements ICatalogoService{
	
	@Autowired
	ICatalogoDAO CatalogoDAO;

	@Override
	public List<Catalogo> getListCatalogos() {
		// TODO Auto-generated method stub
		return CatalogoDAO.getListCatalogos();
	}

	@Override
	public boolean saveCatalogo(Catalogo Catalogo) {
		// TODO Auto-generated method stub
		return CatalogoDAO.saveCatalogo(Catalogo);
	}

	@Override
	public Catalogo getCatalogoById(int id) {
		// TODO Auto-generated method stub
		return CatalogoDAO.getCatalogoById(id);
	}

	@Override
	public Catalogo getCatalogoCategoriaSolicitudById(int idcat) {
		// TODO Auto-generated method stub
		return CatalogoDAO.getCatalogoCategoriaSolicitudById(idcat);
	}

	
	
}
