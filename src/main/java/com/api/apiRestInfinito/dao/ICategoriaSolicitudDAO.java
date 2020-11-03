package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.CategoriaSolicitud;

public interface ICategoriaSolicitudDAO {
	public int generarId();
	public List<CategoriaSolicitud> getListCategoriaSolicitudes();
	public boolean saveCategoriaSolicitud(CategoriaSolicitud CategoriaSolicitud);
	public CategoriaSolicitud getCategoriaSolicitudById(int id);
	public List<CategoriaSolicitud> getListCategoriaSolicitudesSolicitudItemById(int idsolicitud);
}
