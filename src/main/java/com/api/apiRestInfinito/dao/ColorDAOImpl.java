package com.api.apiRestInfinito.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Color;
import com.api.apiRestInfinito.model.Modelo;

@Repository
public class ColorDAOImpl implements IColorDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public List<Color> getListColores() {
		//List<Color> lista;
		try {
			return jdbc.query("select m.* from importadora.color m where m.estado=1",new BeanPropertyRowMapper<Color>(Color.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveColor(Color Color) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.color(idcolor,nombre,estado) values (?,?,?)";
			jdbc.update(sql,id, Color.getNombre(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Color getColorById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.color m where m.estado=1 and m.idcolor=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Color>(Color.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idcolor),0)+1 as idcolor from importadora.color";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Color getColorItemById(int id) {
		String sql;
		try {
			sql="select DISTINCT a.* from importadora.color a,importadora.item i where a.idcolor=i.idcolor and a.estado=1 and a.idcolor=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Color>(Color.class),id);
		} catch (Exception e) {
			return null;
		}
	}


}
