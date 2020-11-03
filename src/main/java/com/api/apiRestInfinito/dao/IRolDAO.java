package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Rol;

public interface IRolDAO {
	List<Rol> AllRoleByUsername(String mail);
}
