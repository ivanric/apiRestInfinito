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
import com.api.apiRestInfinito.model.Dealer;
import com.api.apiRestInfinito.model.PrecioItem;

@Repository
public class CatalogoDAOImpl implements ICatalogoDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	IDealerDAO dealerDAO;
	@Autowired
	IPrecioItemDAO precioItemDAO;
	
	@Override
	public List<Catalogo> getListCatalogos() {
		//List<Catalogo> lista;
		try {
			return jdbc.query("select m.* from importadora.catalogo m where m.estado=1",new BeanPropertyRowMapper<Catalogo>(Catalogo.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveCatalogo(Catalogo Catalogo) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.catalogo(idcat,asignado,iddealer,idprec) values (?,?,?,?)";
			jdbc.update(sql,id, Catalogo.getAsignado(),Catalogo.getIddealer(),Catalogo.getIdprec());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Catalogo getCatalogoById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.catalogo m where m.idcat=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Catalogo>(Catalogo.class),id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int generarId() {
		String sql="select COALESCE(max(idcat),0)+1 as idcat from importadora.catalogo";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Catalogo getCatalogoCategoriaSolicitudById(int idcat) {
		//System.out.println("idcat:"+idcat);
		String sql;
		try {
			sql="select DISTINCT m.* from importadora.catalogo m,categoriasolicitud cs where cs.idcat=m.idcat and m.idcat=? ";
			CatalogoCategoriaSolicitudRowMapper catalogoCategoriaSolicitudRowMapper=new CatalogoCategoriaSolicitudRowMapper();
			return jdbc.queryForObject(sql,catalogoCategoriaSolicitudRowMapper,idcat);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//metodos
	private Dealer mgetDealerCatalogoCategoriaSolicitud(int iddealer) {
		return dealerDAO.getDealerCatalogoById(iddealer);
	}
	private PrecioItem mgetPrecioItemCatalogoCategoriaSolicitud(int idprec) {
		return precioItemDAO.getPrecioItemCatalogoById(idprec);
	}
	
	
	public class CatalogoCategoriaSolicitudRowMapper implements RowMapper<Catalogo>{
		@Override
		public Catalogo mapRow(ResultSet rs, int arg1) throws SQLException {
			Catalogo a= new Catalogo();
			a.setIdcat(rs.getInt("idcat"));
			a.setAsignado(rs.getInt("asignado"));
			a.setIddealer(rs.getInt("iddealer"));
			a.setIdprec(rs.getInt("idprec"));
			try {
				a.setDealer(mgetDealerCatalogoCategoriaSolicitud(rs.getInt("iddealer")));
			} catch (Exception e) {
				a.setDealer(null);
			}
			try {
				a.setPrecioItem(mgetPrecioItemCatalogoCategoriaSolicitud(rs.getInt("idprec")));
			} catch (Exception e) {
				// TODO: handle exception
				a.setPrecioItem(null);
			}

			return a;
	    }
	}


}
