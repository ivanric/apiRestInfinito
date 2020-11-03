package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IEmpresaDAO;
import com.api.apiRestInfinito.model.Empresa;
@Service
public class EmpresaServiceImpl implements IEmpresaService{

	@Autowired 
	private IEmpresaDAO empresaDAO;
	
	@Override
	public List<Empresa> ListEmpresas() {
		return empresaDAO.ListEmpresas();
	}

	@Override
	public Empresa getEmpresaById(int id) {
		// TODO Auto-generated method stub
		return empresaDAO.getEmpresaById(id);
	}

}
