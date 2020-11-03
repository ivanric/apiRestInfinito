package com.api.apiRestInfinito.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.apiRestInfinito.entity.RolRowMapper;
import com.api.apiRestInfinito.model.Rol;


@Transactional
@Repository
public class RolDAOImpl implements IRolDAO{

	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Rol> AllRoleByUsername(String mail) {
		String sql = "SELECT r.* FROM rol r,usuario u,rolusu ru WHERE r.idrol=ru.idrol AND u.idusu=ru.idusu AND u.mail=?";
		RowMapper<Rol> rowMapper = new RolRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper,mail);
	}

}
