package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ILineaDAO;
import com.api.apiRestInfinito.model.Linea;

@Service
public class LineaServiceImpl implements ILineaService{
	
	@Autowired
	ILineaDAO LineaDAO;

	@Override
	public List<Linea> getListLineas() {
		// TODO Auto-generated method stub
		return LineaDAO.getListLineas();
	}

	@Override
	public boolean saveLinea(Linea linea) {
		// TODO Auto-generated method stub
		return LineaDAO.saveLinea(linea);
	}

	@Override
	public Linea getLineaById(int id) {
		// TODO Auto-generated method stub
		return LineaDAO.getLineaById(id);
	}

	@Override
	public Linea getLineaItemById(int id) {
		// TODO Auto-generated method stub
		return LineaDAO.getLineaItemById(id);
	}
	
	
}
