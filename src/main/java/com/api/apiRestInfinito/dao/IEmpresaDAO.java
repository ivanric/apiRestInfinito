package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Empresa;
import com.api.apiRestInfinito.model.Usuario;

public interface IEmpresaDAO {
	public List<Empresa> ListEmpresas();
	public Empresa getEmpresaById(int id);
}
