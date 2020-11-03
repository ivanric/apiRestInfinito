package com.api.apiRestInfinito.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Categoria;
import com.api.apiRestInfinito.model.Color;

@Repository
public class CategoriaDAOImpl implements ICategoriaDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public List<Categoria> getListCategorias() {
		//List<Categoria> lista;
		try {
			return jdbc.query("select m.* from importadora.categoria m where m.estado=1",new BeanPropertyRowMapper<Categoria>(Categoria.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveCategoria(Categoria Categoria) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.categoria(idcat,nombre,estado) values (?,?,?)";
			jdbc.update(sql,id, Categoria.getNombre(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Categoria getCategoriaById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.categoria m where m.estado=? and m.idcat=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Categoria>(Categoria.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idcat),0)+1 as idcat from importadora.categoria";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Categoria getCategoriaItemById(int id) {
		String sql;
		try {
			sql="select DISTINCT a.* from importadora.categoria a,importadora.item i where a.idcat=i.idcat and a.estado=1 and a.idcat=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Categoria>(Categoria.class),id);
		} catch (Exception e) {
			return null;
		}
	}


}
