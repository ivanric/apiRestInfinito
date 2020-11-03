package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ISolicitudItemDAO;
import com.api.apiRestInfinito.model.SolicitudItem;

@Service
public class SolicitudItemServiceImpl implements ISolicitudItemService{
	
	@Autowired
	ISolicitudItemDAO SolicitudItemDAO;

	@Override
	public List<SolicitudItem> getListSolicitudItems() {
		// TODO Auto-generated method stub
		return SolicitudItemDAO.getListSolicitudItems();
	}

	@Override
	public boolean saveSolicitudItem(SolicitudItem SolicitudItem) {
		// TODO Auto-generated method stub
		return SolicitudItemDAO.saveSolicitudItem(SolicitudItem);
	}

	@Override
	public SolicitudItem getSolicitudItemById(int id) {
		// TODO Auto-generated method stub
		return SolicitudItemDAO.getSolicitudItemById(id);
	}

	
}
