package com.api.apiRestInfinito.dao;

import java.util.Map;

import com.api.apiRestInfinito.model.Usuario;

public interface ILoginDAO {
	Usuario getUserByMail(String mail);
	Map<String, Object> getDataLogin(String mail);
}
