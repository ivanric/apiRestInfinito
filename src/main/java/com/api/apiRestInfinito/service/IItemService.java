package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Item;

public interface IItemService {
	public List<Item> getListItems();
	public boolean saveItem(Item Item);
	public Item getItemById(int id);
	public Item getItemPrecioItemById(int id);
	public Item getItemCategoriaSolicitudById(int iditem);
	
}
