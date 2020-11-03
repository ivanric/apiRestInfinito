package com.api.apiRestInfinito.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Color;
import com.api.apiRestInfinito.model.Linea;

@Repository
public class LineaDAOImpl implements ILineaDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public List<Linea> getListLineas() {
		//List<Linea> lista;
		try {
			return jdbc.query("select m.* from importadora.linea m where m.estado=1",new BeanPropertyRowMapper<Linea>(Linea.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveLinea(Linea Linea) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.linea(idlinea,nombre,estado) values (?,?,?)";
			jdbc.update(sql,id, Linea.getNombre(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Linea getLineaById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.linea m where m.estado=1 and m.idlinea=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Linea>(Linea.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idlinea),0)+1 as idlinea from importadora.linea";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Linea getLineaItemById(int id) {
		String sql;
		try {
			sql="select DISTINCT a.* from importadora.linea  a,importadora.item i where a.idlinea=i.idlinea and a.estado=1 and a.idlinea=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Linea>(Linea.class),id);
		} catch (Exception e) {
			return null;
		}
	}


}
