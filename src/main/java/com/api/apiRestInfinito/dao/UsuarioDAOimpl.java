package com.api.apiRestInfinito.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.api.apiRestInfinito.model.Usuario;

@Transactional
@Repository
public class UsuarioDAOimpl implements IUsuarioDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Override
	public int generarIdUser() {
		String sql="select COALESCE(max(idusu),0)+1 as idusu from usuario";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	@Override
	public int generarIdUserEmp() {
		String sql="select COALESCE(max(idusuemp),0)+1 as idusuemp from usuemp";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public boolean saveUsuario(Usuario user,int idemp) {
		int id= generarIdUser();
		int idusuemp= generarIdUserEmp();
		String sql;
		try {
			//Add Persona
			sql = "insert into usuario(idusu,username,mail,password,tipo,idper,estado) values(?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,id,user.getUsername(),user.getMail(),user.getPassword(),user.getTipo(),user.getIdper(),1);
			//agregando la empresa al usuaru
			sql="insert into usuemp(idusuemp,idusu,idemp,habilitado) values(?,?,?,?)";
			jdbcTemplate.update(sql,idusuemp,id,idemp,0);
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public Usuario findByEmail(String mail) {
		String sql="";
		Usuario usuario =null;
		try {
			sql = "SELECT * FROM usuario WHERE mail=?";
			RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
			usuario = jdbcTemplate.queryForObject(sql, rowMapper, mail);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			usuario=null;
		}
		return usuario;
	}
	@Override
	public Usuario getUsuarioById(int id) {
		String sql;
		try {
			sql="select u.* from usuario u where u.estado=1 and u.idusu=? ";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Usuario>(Usuario.class),id);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Usuario getUsuarioPersonaByIdper(int idper) {
		String sql;
		try {
			sql="select u.* from usuario u,persona p where u.estado=1 and u.idper=p.idper  and u.idper=? ";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Usuario>(Usuario.class),idper);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Usuario getUsuarioPersonaByIdusu(int idusu) {
		String sql;
		try {
			sql="select u.* from usuario u,persona p where u.estado=1 and u.idper=p.idper  and u.idusu=? ";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Usuario>(Usuario.class),idusu);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Usuario getUsuarioPersonaDealerByIdusu(int idper) {
		String sql;
		try {
			sql="select u.* from usuario u,dealer.usudel us where us.idusu=u.idusu and u.estado=1 and u.idper=? ";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Usuario>(Usuario.class),idper);
		} catch (Exception e) {
			return null;
		}
	}


}
