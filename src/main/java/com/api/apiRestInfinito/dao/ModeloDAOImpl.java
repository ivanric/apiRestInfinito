package com.api.apiRestInfinito.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Marca;
import com.api.apiRestInfinito.model.Modelo;

@Repository
public class ModeloDAOImpl implements IModeloDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public int generarId() {
		String sql="select COALESCE(max(idmod),0)+1 as idmod from importadora.modelo";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Modelo> getListModelos() {
		try {
			return jdbc.query("select m.* from importadora.modelo m where m.estado=1",new BeanPropertyRowMapper<Modelo>(Modelo.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveModelo(Modelo modelo) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.modelo(idmod,nombre,estado,idmarc,anho) values (?,?,?,?,?)";
			jdbc.update(sql,id, modelo.getNombre(),1,modelo.getIdmarc(),modelo.getAnho());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Modelo getModeloById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.modelo m where m.estado=1 and m.idmod=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Modelo>(Modelo.class),id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	
	
	@Override
	public List<Modelo> getListModelosMarcaById(int id) {
		try {
			return jdbc.query("select DISTINCT m.* from importadora.modelo m,importadora.marca mc where mc.idmarc=m.idmarc and m.idmarc=? and m.estado=1",new BeanPropertyRowMapper<Modelo>(Modelo.class),id);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Modelo getModeloItemById(int idmod) {
		String sql;
		try {
			sql="select DISTINCT m.* from importadora.modelo m,importadora.item i where m.idmod=i.idmod and m.estado=1 and m.idmod=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Modelo>(Modelo.class),idmod);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

}
