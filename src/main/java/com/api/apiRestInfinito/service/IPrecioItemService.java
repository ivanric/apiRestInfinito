package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Linea;
import com.api.apiRestInfinito.model.PrecioItem;



public interface IPrecioItemService {
	public List<PrecioItem> getListPrecioItems();
	public boolean savePrecioItem(PrecioItem modelo);
	public PrecioItem getPrecioItemById(int id);
	public List<PrecioItem> getListPrecioItemsItemById(int id);
	
	public PrecioItem getPrecioItemCatalogoById(int idprec);
	
}
