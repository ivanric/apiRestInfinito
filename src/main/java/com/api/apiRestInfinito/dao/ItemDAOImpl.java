package com.api.apiRestInfinito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Categoria;
import com.api.apiRestInfinito.model.Color;
import com.api.apiRestInfinito.model.Item;
import com.api.apiRestInfinito.model.Linea;
import com.api.apiRestInfinito.model.Modelo;

@Repository
public class ItemDAOImpl implements IItemDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	private IModeloDAO modeloDAO;
	@Autowired
	private IColorDAO colorDAO;
	@Autowired
	private ICategoriaDAO categoriaDAO;
	@Autowired
	private ILineaDAO lineaDAO;
	
	@Override
	public List<Item> getListItems() {
		//List<Item> lista;
		try {
			return jdbc.query("select m.* from importadora.item m where m.disponible=1",new BeanPropertyRowMapper<Item>(Item.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveItem(Item Item) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO importadora.item(iditem,idmod,idcolor,idcat,idusu,disponible,idlinea,idemp) values (?,?,?,?,?,?,?,?)";
			jdbc.update(sql,id,Item.getIdmod(),Item.getIdcolor(),Item.getIdcat(),Item.getIdusu(),Item.getDisponible(),Item.getLinea(),Item.getIditem());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Item getItemById(int id) {
		String sql;
		try {
			sql="select m.* from importadora.item m where m.disponible=1 and m.iditem=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Item>(Item.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(iditem),0)+1 as iditem from importadora.item";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Item getItemPrecioItemById(int iditem) {
		System.out.println("iditem:"+iditem);
		String sql;
		try {
			sql="select  DISTINCT a.* from importadora.item a,importadora.precioitem i where a.iditem=i.iditem and a.disponible=1 and a.iditem=? ";
			ItemPrecioItemRowMapper itemPrecioItemRowMapper=new ItemPrecioItemRowMapper();
			return jdbc.queryForObject(sql,itemPrecioItemRowMapper,iditem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Item getItemCategoriaSolicitudById(int iditem) {
		//System.out.println("iditem:"+iditem);
		String sql;
		try {
			sql="select DISTINCT a.* from importadora.item a,categoriasolicitud i where a.iditem=i.iditem and a.disponible=1 and a.iditem=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Item>(Item.class),iditem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	//metodos
	private Modelo mgetModelo_ItemPrecioItem(int idmod) {
		return modeloDAO.getModeloItemById(idmod);
	}
	private Color mgetColor_ItemPrecioItem(int idcolor) {
		return colorDAO.getColorItemById(idcolor);
	}
	private Categoria mgetCategoria_ItemPrecioItem(int idcat) {
		return categoriaDAO.getCategoriaItemById(idcat);
	}
	private Linea mgetLinea_ItemPrecioItem(int idlinea) {
		return lineaDAO.getLineaItemById(idlinea);
	}

	
	public class ItemPrecioItemRowMapper implements RowMapper<Item>{
		@Override
		public Item mapRow(ResultSet rs, int arg1) throws SQLException {
			Item a= new Item();
			a.setIditem(rs.getInt("iditem"));
			a.setIdmod(rs.getInt("idmod"));
			a.setIdcolor(rs.getInt("idcolor"));
			a.setIdcat(rs.getInt("idcat"));
			a.setIdusu(rs.getInt("idusu"));
			a.setDisponible(rs.getInt("disponible"));
			a.setIdlinea(rs.getInt("idlinea"));
			a.setIdemp(rs.getInt("idemp"));
			try {
				a.setModelo(mgetModelo_ItemPrecioItem(rs.getInt("idmod")));
			} catch (Exception e) {
				a.setModelo(null);
			}
			
			try {
				a.setColor(mgetColor_ItemPrecioItem(rs.getInt("idcolor")));
			} catch (Exception e) {
				a.setColor(null);
			}
			
			try {
				a.setCategoria(mgetCategoria_ItemPrecioItem(rs.getInt("idcat")));
			} catch (Exception e) {
				a.setCategoria(null);
			}
			try {
				a.setLinea(mgetLinea_ItemPrecioItem(rs.getInt("idlinea")));
			} catch (Exception e) {
				a.setLinea(null);
			}
			

			return a;
	    }
	}


}
