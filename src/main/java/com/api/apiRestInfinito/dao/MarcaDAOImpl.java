package com.api.apiRestInfinito.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Marca;

@Repository
public class MarcaDAOImpl implements IMarcaDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public List<Marca> getListMarcas() {
		//List<Marca> lista;
		try {
			return jdbc.query("select m.* from importadora.marca m where m.estado=1",new BeanPropertyRowMapper<Marca>(Marca.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveMarca(Marca marca) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.marca(idmarc,nombre,estado) values (?,?,?)";
			jdbc.update(sql,id, marca.getNombre(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Marca getMarcaById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.marca m where m.estado=1 and m.idmarc=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Marca>(Marca.class),id);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Marca getMarcaModeloById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.marca m,importadora.modelo md where md.idmarc=m.idmarc and m.estado=1 and m.idmarc=?";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Marca>(Marca.class),id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int generarId() {
		String sql="select COALESCE(max(idmarc),0)+1 as idmarc from importadora.marca";
		return jdbc.queryForObject(sql, Integer.class);
	}


}
