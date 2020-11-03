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
import com.api.apiRestInfinito.model.Item;
import com.api.apiRestInfinito.model.Linea;
import com.api.apiRestInfinito.model.Marca;
import com.api.apiRestInfinito.model.PrecioItem;

@Repository
public class PrecioItemDAOImpl implements IPrecioItemDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	private IItemDAO itemDAO;
	
	@Override
	public int generarId() {
		String sql="select COALESCE(max(idprec),0)+1 as idprec from importadora.precioitem";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public List<PrecioItem> getListPrecioItems() {
		try {
			return jdbc.query("select m.* from importadora.precioitem m where m.estado=1",new BeanPropertyRowMapper<PrecioItem>(PrecioItem.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean savePrecioItem(PrecioItem precioItem) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.precioitem(idprec,num,precio,estado,iditem) values (?,?,?,?,?)";
			jdbc.update(sql,id, precioItem.getNum(),precioItem.getPrecio(),1,precioItem.getIditem());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public PrecioItem getPrecioItemById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.precioitem m where m.estado=1 and m.idprec=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<PrecioItem>(PrecioItem.class),id);
		} catch (Exception e) {
			return null;
		}
	}

	
	
	@Override
	public List<PrecioItem> getListPrecioItemsItemById(int id) {
		try {
			return jdbc.query("select m.* from importadora.precioitem m,importadora.item mc where mc.iditem=m.iditem and m.iditem=? and m.estado=1",new BeanPropertyRowMapper<PrecioItem>(PrecioItem.class),id);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public PrecioItem getPrecioItemCatalogoById(int idprec) {
		//System.out.println("idprec:"+idprec);
		String sql;
		try {
			sql="select a.* from importadora.precioitem  a,importadora.catalogo i where a.idprec=i.idprec and a.estado=1 and a.idprec=? ";
			PrecioItemCatalogoRowMapper precioItemCatalogoRowMapper=new PrecioItemCatalogoRowMapper();
			return jdbc.queryForObject(sql,precioItemCatalogoRowMapper,idprec);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//metodos
	private Item mgetItem_PrecioItemCatalogo(int iditem) {
		return itemDAO.getItemPrecioItemById(iditem);
	}
	
	public class PrecioItemCatalogoRowMapper implements RowMapper<PrecioItem>{
		@Override
		public PrecioItem mapRow(ResultSet rs, int arg1) throws SQLException {
			PrecioItem a= new PrecioItem();
			a.setIdprec(rs.getInt("idprec"));
			a.setNum(rs.getInt("num"));
			a.setPrecio(rs.getDouble("precio"));
			a.setIditem(rs.getInt("iditem"));
			try {
				a.setItem(mgetItem_PrecioItemCatalogo(rs.getInt("iditem")));
			} catch (Exception e) {
				a.setItem(null);
			}

			return a;
	    }
	}


}
