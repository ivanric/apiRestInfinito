package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IMarcaDAO;
import com.api.apiRestInfinito.model.Marca;

@Service
public class MarcaServiceImpl implements IMarcaService{
	
	@Autowired
	IMarcaDAO marcaDAO;
	
	@Override
	public List<Marca> getListMarcas() {
		// TODO Auto-generated method stub
		return marcaDAO.getListMarcas();
	}

	@Override
	public boolean saveMarca(Marca marca) {
		// TODO Auto-generated method stub
		return marcaDAO.saveMarca(marca);
	}

	@Override
	public Marca getMarcaById(int id) {
		// TODO Auto-generated method stub
		return marcaDAO.getMarcaById(id);
	}

	@Override
	public Marca getMarcaModeloById(int id) {
		// TODO Auto-generated method stub
		return marcaDAO.getMarcaModeloById(id);
	}

}
