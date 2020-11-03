package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Recibo;

public interface IReciboDAO {
	public int generarId();
	public List<Recibo> getListRecibos();
	public boolean saveRecibo(Recibo Recibo);
	public Recibo getReciboById(int id);
	
	public List<Recibo> getListReciboSolicitudItemById(int idsolicitud);
	

}
