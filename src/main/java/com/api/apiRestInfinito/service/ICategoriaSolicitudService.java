package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.CategoriaSolicitud;

public interface ICategoriaSolicitudService {
	public List<CategoriaSolicitud> getListCategoriaSolicitudes();
	public boolean saveCategoriaSolicitud(CategoriaSolicitud CategoriaSolicitud);
	public CategoriaSolicitud getCategoriaSolicitudById(int id);
	
	public List<CategoriaSolicitud> getListCategoriaSolicitudesSolicitudItemById(int id);
}
