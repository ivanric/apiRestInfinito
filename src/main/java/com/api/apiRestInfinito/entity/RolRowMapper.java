package com.api.apiRestInfinito.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.api.apiRestInfinito.model.Rol;

public class RolRowMapper implements RowMapper<Rol>{	
	@Override
	public Rol mapRow(ResultSet row, int rowNum) throws SQLException {
		Rol r=new Rol();
		r.setIdrol(row.getInt("idrol"));
		r.setNombre(row.getString("nombre"));
		r.setEstado(row.getInt("estado"));
		return r;
	}
	
}