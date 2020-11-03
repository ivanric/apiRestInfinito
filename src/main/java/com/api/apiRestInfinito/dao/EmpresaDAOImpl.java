package com.api.apiRestInfinito.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Empresa;
import com.api.apiRestInfinito.model.Usuario;
@Repository
public class EmpresaDAOImpl implements IEmpresaDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	@Override
	public List<Empresa> ListEmpresas() {
		try {
			return db.query("select * from empresa",new BeanPropertyRowMapper<Empresa>(Empresa.class));
		} catch (Exception e) {//DataAccessException e
			return null;
		}
	}

	@Override
	public Empresa getEmpresaById(int id) {
		String sql;
		try {
			sql="select e.* from empresa e where e.estado=1 and e.idemp=? ";
			return db.queryForObject(sql,new BeanPropertyRowMapper<Empresa>(Empresa.class),id);
		} catch (Exception e) {
			return null;
		}
	}
}
