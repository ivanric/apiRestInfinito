package com.api.apiRestInfinito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.CategoriaSolicitud;
import com.api.apiRestInfinito.model.Dealer;
import com.api.apiRestInfinito.model.Recibo;
import com.api.apiRestInfinito.model.SolicitudItem;
import com.api.apiRestInfinito.model.UsuarioDealer;
@Repository
public class SolicitudItemDAOImpl implements ISolicitudItemDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	private IUsuarioDealerDAO usuarioDealer;
	
	@Autowired
	private ICategoriaSolicitudDAO categoriaSolicitud;
	
	@Autowired IReciboDAO recibo;
	
	public class SolicitudItemRowMapper implements RowMapper<SolicitudItem>{
		@Override
		public SolicitudItem mapRow(ResultSet rs, int arg1) throws SQLException {
			SolicitudItem a= new SolicitudItem();
			a.setIdsolicitud(rs.getInt("idsolicitud"));
			a.setIdusudelsolicitante(rs.getInt("idusudelsolicitante"));
			a.setIdusudelreceptor(rs.getInt("idusudelreceptor"));
			a.setMetodopago(rs.getString("metodopago"));
			a.setFecha(rs.getString("fecha"));
			a.setNum_solicitud(rs.getLong("num_solicitud"));
			a.setCantidaditems(rs.getInt("cantidaditems"));
			a.setAprovado(rs.getInt("aprovado"));
			a.setTotalbolivianos(rs.getDouble("totalbolivianos"));
			a.setSolicitudcerrada(rs.getInt("solicitudcerrada"));
			a.setCantidaditems(rs.getInt("cantidaditemspagados"));
			
			try {
				a.setUsuarioDealerSolicitante(mgetDealerSolicitante(rs.getInt("idusudelsolicitante")));
			} catch (Exception e) {
				a.setUsuarioDealerSolicitante(null);
			}
			try {
				a.setUsuarioDealerRecetor(mgetDealerReceptor(rs.getInt("idusudelreceptor")));
			} catch (Exception e) {
				a.setUsuarioDealerRecetor(null);
			}
			try {
				a.setCategoriasSolicitudItemList(mgetCategoriasSolicitudItemList(rs.getInt("idsolicitud")));
			} catch (Exception e) {
				// TODO: handle exception
				a.setCategoriasSolicitudItemList(null);
			}
			try {
				a.setRecibosSolicitudItemList(mgetRecibosSolicitudItemList(rs.getInt("idsolicitud")));
			} catch (Exception e) {
				// TODO: handle exception
				a.setRecibosSolicitudItemList(null);
			}
			return a;
	    }
	}

	//metodos 
	public UsuarioDealer mgetDealerSolicitante(int idusudelsolicitante) {
		return usuarioDealer.getUsuarioDealerById(idusudelsolicitante);
	}
	public UsuarioDealer mgetDealerReceptor(int idusudelreceptor) {
		return usuarioDealer.getUsuarioDealerById(idusudelreceptor);
	}
	public List<CategoriaSolicitud> mgetCategoriasSolicitudItemList(int idsolicitud) {
		return categoriaSolicitud.getListCategoriaSolicitudesSolicitudItemById(idsolicitud);		
	}
	public List<Recibo> mgetRecibosSolicitudItemList(int idsolicitud){
		return recibo.getListReciboSolicitudItemById(idsolicitud);
	}
	
	
	
	@Override
	public List<SolicitudItem> getListSolicitudItems() {
		try {
			//return jdbc.query("select m.* from solicituditem m where m.aprovado=1",new BeanPropertyRowMapper<SolicitudItem>(SolicitudItem.class));
			SolicitudItemRowMapper solicitudItemRowMapper=new SolicitudItemRowMapper();	
			return jdbc.query("select m.* from solicituditem m where m.aprovado=1",solicitudItemRowMapper);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveSolicitudItem(SolicitudItem SolicitudItem) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO solicituditem(idsolicitud,idusudelsolicitante,metodopago,fecha,num_solicitud,totaldolares,cantidaditems,idusudelreceptor,aprovado,totalbolivianos,solicitudcerrada,cantidaditemspagados) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbc.update(sql,id,SolicitudItem.getIdusudelsolicitante(),SolicitudItem.getMetodopago(),SolicitudItem.getFecha(),SolicitudItem.getNum_solicitud(),SolicitudItem.getTotaldolares(),SolicitudItem.getCantidaditems(),SolicitudItem.getIdusudelreceptor(),SolicitudItem.getAprovado(),SolicitudItem.getTotalbolivianos(),SolicitudItem.getSolicitudcerrada(),SolicitudItem.getCantidaditemspagados());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public SolicitudItem getSolicitudItemById(int id) {
		String sql;
		try {
			sql="select m.* from solicituditem m where m.aprovado=1 and m.idsolicitud=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<SolicitudItem>(SolicitudItem.class),id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idsolicitud),0)+1 as idsolicitud from solicituditem";
		return jdbc.queryForObject(sql, Integer.class);
	}

}
