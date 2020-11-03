package com.api.apiRestInfinito.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Marca;
import com.api.apiRestInfinito.model.Recibo;

@Repository
public class ReciboDAOImpl implements IReciboDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public int generarId() {
		String sql="select COALESCE(max(idrecib),0)+1 as idrecib from recibo";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Recibo> getListRecibos() {
		try {
			return jdbc.query("select m.* from recibo m where m.estado=1",new BeanPropertyRowMapper<Recibo>(Recibo.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveRecibo(Recibo Recibo) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO recibo(idrecib,idsolicitud,urlarchivo,tipo,idusu,estado) values (?,?,?,?,?,?)";
			jdbc.update(sql,id, Recibo.getIdsolicitud(),Recibo.getUrlarchivo(),Recibo.getTipo(),Recibo.getIdusu(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Recibo getReciboById(int id) {
		String sql;
		try {
			sql="select m.* from recibo m where m.estado=1 and m.idrecib=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Recibo>(Recibo.class),id);
		} catch (Exception e) {
			return null;
		}
	}

	
	
	@Override
	public List<Recibo> getListReciboSolicitudItemById(int idsolicitud) {
		try {
			return jdbc.query("select m.* from recibo m,solicituditem mc where mc.idsolicitud=m.idsolicitud and m.idsolicitud=? and m.estado=1",new BeanPropertyRowMapper<Recibo>(Recibo.class),idsolicitud);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}



}
