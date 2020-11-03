package com.api.apiRestInfinito.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.apiRestInfinito.model.Usuario;


@Transactional
@Repository
public class LoginDAOImpl implements ILoginDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public Usuario getUserByMail(String mail) {
		String sql = "SELECT * FROM usuario WHERE mail=? and estado=1";
		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario Usuario = jdbcTemplate.queryForObject(sql, rowMapper, mail);
		return Usuario;
	}

	@Override
	public Map<String, Object> getDataLogin(String mail) {
		String sql;
		try {
			sql="SELECT usr.idusu,usr.username,usr.mail,usr.foto,usr.creado,usr.estado  FROM public.usuario usr WHERE usr.mail=?";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		return jdbcTemplate.queryForMap(sql,new Object[]{mail});
	}
}
