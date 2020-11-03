package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IPrecioItemDAO;
import com.api.apiRestInfinito.model.PrecioItem;

@Service
public class PrecioItemServiceImpl implements IPrecioItemService{
	
	@Autowired
	IPrecioItemDAO PrecioItemDAO;

	@Override
	public List<PrecioItem> getListPrecioItems() {
		// TODO Auto-generated method stub
		return PrecioItemDAO.getListPrecioItems();
	}

	@Override
	public boolean savePrecioItem(PrecioItem PrecioItem) {
		// TODO Auto-generated method stub
		return PrecioItemDAO.savePrecioItem(PrecioItem);
	}

	@Override
	public PrecioItem getPrecioItemById(int id) {
		// TODO Auto-generated method stub
		return PrecioItemDAO.getPrecioItemById(id);
	}

	@Override
	public List<PrecioItem> getListPrecioItemsItemById(int id) {
		// TODO Auto-generated method stub
		return PrecioItemDAO.getListPrecioItemsItemById(id);
	}

	@Override
	public PrecioItem getPrecioItemCatalogoById(int idprec) {
		// TODO Auto-generated method stub
		return PrecioItemDAO.getPrecioItemCatalogoById(idprec);
	}
	
	
}
