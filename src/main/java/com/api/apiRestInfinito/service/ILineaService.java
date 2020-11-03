package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Linea;



public interface ILineaService {
	public List<Linea> getListLineas();
	public boolean saveLinea(Linea linea);
	public Linea getLineaById(int id);
	
	public Linea getLineaItemById(int id);
	
}
