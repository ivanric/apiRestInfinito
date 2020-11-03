package com.api.apiRestInfinito.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Dealer;
import com.api.apiRestInfinito.model.Linea;

@Repository
public class DealerDAOImpl implements IDealerDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Override
	public List<Dealer> getListDealers() {
		//List<Dealer> lista;
		try {
			return jdbc.query("select m.* from dealer.dealer m where m.estado=1",new BeanPropertyRowMapper<Dealer>(Dealer.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveDealer(Dealer Dealer) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO dealer.dealer(iddealer,nombre_empresa,propietario,num_telefono,estado,lalitud,longitud,tipo,pertenecedealer) values (?,?,?,?,?,?,?,?,?)";
			jdbc.update(sql,id, Dealer.getNombre_empresa(),Dealer.getPropietario(),Dealer.getNum_telefono(),1,Dealer.getLatitud(),Dealer.getLongitud(),Dealer.getTipo(),Dealer.getPertencedealer());
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public Dealer getDealerById(int id) {
		String sql;
		//System.out.println("iddealer:"+id);
		try {
			sql="select m.* from dealer.dealer m where m.estado=1 and m.iddealer=?";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Dealer>(Dealer.class),id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(iddealer),0)+1 as iddealer from dealer.dealer";
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public Dealer getDealerCatalogoById(int iddealer) {
		//System.out.println("iddealer:"+iddealer);
		String sql;
		try {
			sql="select DISTINCT a.* from dealer.dealer a,importadora.catalogo i where a.iddealer=i.iddealer and a.estado=1 and a.iddealer=? ";
			return jdbc.queryForObject(sql,new BeanPropertyRowMapper<Dealer>(Dealer.class),iddealer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


}
