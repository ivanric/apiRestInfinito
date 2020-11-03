package com.api.apiRestInfinito.service;

import java.util.List;


import com.api.apiRestInfinito.model.Empresa;


public interface IEmpresaService {
	public List<Empresa> ListEmpresas();
	public Empresa getEmpresaById(int id);
}
