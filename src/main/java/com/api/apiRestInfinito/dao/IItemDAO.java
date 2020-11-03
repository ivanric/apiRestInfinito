package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Item;

public interface IItemDAO {
	public int generarId();
	public List<Item> getListItems();
	public boolean saveItem(Item Item);
	public Item getItemById(int id);
	public Item getItemPrecioItemById(int iditem);
	public Item getItemCategoriaSolicitudById(int iditem);
}
