package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.SolicitudItem;


public interface ISolicitudItemService {
	public List<SolicitudItem> getListSolicitudItems();
	public boolean saveSolicitudItem(SolicitudItem SolicitudItem);
	public SolicitudItem getSolicitudItemById(int id);
	
}
