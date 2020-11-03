package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Catalogo;



public interface ICatalogoService {
	public List<Catalogo> getListCatalogos();
	public boolean saveCatalogo(Catalogo Catalogo);
	public Catalogo getCatalogoById(int id);
	public Catalogo getCatalogoCategoriaSolicitudById(int idcat);
}
