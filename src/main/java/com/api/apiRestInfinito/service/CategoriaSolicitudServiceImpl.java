package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ICategoriaSolicitudDAO;
import com.api.apiRestInfinito.model.CategoriaSolicitud;

@Service
public class CategoriaSolicitudServiceImpl implements ICategoriaSolicitudService{
	
	@Autowired
	ICategoriaSolicitudDAO CategoriaSolicitudDAO;

	@Override
	public List<CategoriaSolicitud> getListCategoriaSolicitudes() {
		// TODO Auto-generated method stub
		return CategoriaSolicitudDAO.getListCategoriaSolicitudes();
	}

	@Override
	public boolean saveCategoriaSolicitud(CategoriaSolicitud CategoriaSolicitud) {
		// TODO Auto-generated method stub
		return CategoriaSolicitudDAO.saveCategoriaSolicitud(CategoriaSolicitud);
	}

	@Override
	public CategoriaSolicitud getCategoriaSolicitudById(int id) {
		// TODO Auto-generated method stub
		return CategoriaSolicitudDAO.getCategoriaSolicitudById(id);
	}



	@Override
	public List<CategoriaSolicitud> getListCategoriaSolicitudesSolicitudItemById(int id) {
		// TODO Auto-generated method stub
		return CategoriaSolicitudDAO.getListCategoriaSolicitudesSolicitudItemById(id);
	}
	
	
}
