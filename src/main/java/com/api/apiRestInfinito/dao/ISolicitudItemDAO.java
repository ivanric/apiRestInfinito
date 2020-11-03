package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.SolicitudItem;

public interface ISolicitudItemDAO {
	public int generarId();
	public List<SolicitudItem> getListSolicitudItems();
	public boolean saveSolicitudItem(SolicitudItem SolicitudItem);
	public SolicitudItem getSolicitudItemById(int id);
}
