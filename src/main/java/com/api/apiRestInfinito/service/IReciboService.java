package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Modelo;
import com.api.apiRestInfinito.model.Recibo;



public interface IReciboService {
	public List<Recibo> getListRecibos();
	public boolean saveRecibo(Recibo Recibo);
	public Recibo getReciboById(int id);
	
	public List<Recibo> getListReciboSolicitudItemById(int id);
}
