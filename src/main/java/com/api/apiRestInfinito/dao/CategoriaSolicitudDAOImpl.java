package com.api.apiRestInfinito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Catalogo;
import com.api.apiRestInfinito.model.CategoriaSolicitud;
import com.api.apiRestInfinito.model.Item;
import com.api.apiRestInfinito.model.SolicitudItem;
@Repository
public class CategoriaSolicitudDAOImpl implements ICategoriaSolicitudDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	private ICatalogoDAO catalogoDAO;
	
	@Autowired
	private IItemDAO itemDAO;
	
	@Override
	public List<CategoriaSolicitud> getListCategoriaSolicitudes() {
		//List<CategoriaSolicitud> lista;
		try {
			return jdbc.query("select m.* from categoriasolicitud m where m.estado=1",new BeanPropertyRowMapper<CategoriaSolicitud>(CategoriaSolicitud.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveCategoriaSolicitud(CategoriaSolicitud CategoriaSolicitud) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO categoriasolicitud(idsoltcat,idcat,iditem,sub_total,idsolicitud,cantidad) values (?,?,?,?,?,?)";
			jdbc.update(sql,id, CategoriaSolicitud.getIdcat(),CategoriaSolicitud.getIditem(),CategoriaSolicitud.getSub_total(),CategoriaSolicitud.getCantidad());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public CategoriaSolicitud getCategoriaSolicitudById(int id) {
		String sql;
		try {
			sql="select m.* from categoriasolicitud m where m.estado=1 and m.idsoltcat=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<CategoriaSolicitud>(CategoriaSolicitud.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idsoltcat),0)+1 as idsoltcat from categoriasolicitud";
		return jdbc.queryForObject(sql, Integer.class);
	}


	@Override
	public List<CategoriaSolicitud> getListCategoriaSolicitudesSolicitudItemById(int idsolicitud) {
		try {
			String sql="select m.* from categoriasolicitud m,solicituditem mc where mc.idsolicitud=m.idsolicitud and m.idsolicitud=?";
			CategoriaSolicitudItemRowMapper categoriaSolicitudItemRowMapper=new CategoriaSolicitudItemRowMapper();
			return jdbc.query(sql,categoriaSolicitudItemRowMapper,idsolicitud);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Catalogo mgetCatalogoCategoriaSolicitud(int idcat) {
		return catalogoDAO.getCatalogoCategoriaSolicitudById(idcat);
	}
	public Item mgetItemCategoriaSolicitud(int iditem) {
		return itemDAO.getItemCategoriaSolicitudById(iditem);
	}
	public class CategoriaSolicitudItemRowMapper implements RowMapper<CategoriaSolicitud>{
		@Override
		public CategoriaSolicitud mapRow(ResultSet rs, int arg1) throws SQLException {
			CategoriaSolicitud a= new CategoriaSolicitud();
			a.setIdsoltcat(rs.getInt("idsoltcat"));
			a.setIdcat(rs.getInt("idcat"));
			a.setIditem(rs.getInt("iditem"));
			a.setSub_total(rs.getDouble("sub_total"));
			a.setIdsolicitud(rs.getInt("idsolicitud"));
			a.setCantidad(rs.getInt("cantidad"));
			try {
				a.setCatalogo(mgetCatalogoCategoriaSolicitud(rs.getInt("idcat")));
			} catch (Exception e) {
				a.setCatalogo(null);
			}
			try {
				a.setItem(mgetItemCategoriaSolicitud(rs.getInt("iditem")));
			} catch (Exception e) {
				// TODO: handle exception
				a.setItem(null);
			}

			return a;
	    }
	}



}
