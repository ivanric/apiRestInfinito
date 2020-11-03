package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IModeloDAO;
import com.api.apiRestInfinito.model.Modelo;

@Service
public class ModeloServiceImpl implements IModeloService{
	
	@Autowired
	IModeloDAO ModeloDAO;
	
	@Override
	public List<Modelo> getListModelos() {
		// TODO Auto-generated method stub
		return ModeloDAO.getListModelos();
	}

	@Override
	public boolean saveModelo(Modelo Modelo) {
		// TODO Auto-generated method stub
		return ModeloDAO.saveModelo(Modelo);
	}

	@Override
	public Modelo getModeloById(int id) {
		// TODO Auto-generated method stub
		return ModeloDAO.getModeloById(id);
	}

	@Override
	public List<Modelo> getListModelosMarcaById(int id) {
		return ModeloDAO.getListModelosMarcaById(id);
	}

	@Override
	public Modelo getModeloItemById(int id) {
		// TODO Auto-generated method stub
		return ModeloDAO.getModeloItemById(id);
	}

}
