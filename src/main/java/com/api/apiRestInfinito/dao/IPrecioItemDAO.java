package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.PrecioItem;


public interface IPrecioItemDAO {
	public int generarId();
	public List<PrecioItem> getListPrecioItems();
	public boolean savePrecioItem(PrecioItem modelo);
	public PrecioItem getPrecioItemById(int id);
	public List<PrecioItem> getListPrecioItemsItemById(int id);
	
	public PrecioItem getPrecioItemCatalogoById(int idprec);
	
}
