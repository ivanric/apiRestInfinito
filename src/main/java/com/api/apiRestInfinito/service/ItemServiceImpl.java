package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IItemDAO;
import com.api.apiRestInfinito.model.Item;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	IItemDAO ItemDAO;

	@Override
	public List<Item> getListItems() {
		// TODO Auto-generated method stub
		return ItemDAO.getListItems();
	}

	@Override
	public boolean saveItem(Item Item) {
		// TODO Auto-generated method stub
		return ItemDAO.saveItem(Item);
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return ItemDAO.getItemById(id);
	}

	@Override
	public Item getItemPrecioItemById(int id) {
		// TODO Auto-generated method stub
		return ItemDAO.getItemPrecioItemById(id);
	}

	@Override
	public Item getItemCategoriaSolicitudById(int iditem) {
		// TODO Auto-generated method stub
		return ItemDAO.getItemCategoriaSolicitudById(iditem);
	}
	
	
}
