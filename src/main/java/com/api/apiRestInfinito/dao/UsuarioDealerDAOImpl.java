package com.api.apiRestInfinito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.apiRestInfinito.model.Dealer;
import com.api.apiRestInfinito.model.Persona;
import com.api.apiRestInfinito.model.Usuario;
import com.api.apiRestInfinito.model.UsuarioDealer;

@Repository
public class UsuarioDealerDAOImpl implements IUsuarioDealerDAO{
	@Autowired
	private  JdbcTemplate jdbc;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Autowired
	private IPersonaDAO personaDAO;
	@Autowired
	private IDealerDAO dealerDAO;
	
	@Override
	public List<UsuarioDealer> getListUsuarioDealers() {
		//List<UsuarioDealer> lista;
		try {
			return jdbc.query("select m.* from dealer.usudel m where m.estado=1",new BeanPropertyRowMapper<UsuarioDealer>(UsuarioDealer.class));
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean saveUsuarioDealer(UsuarioDealer UsuarioDealer) {
		int id= generarId();
		String sql;
		
		boolean resp=false;
		try {
			sql = "INSERT INTO dealer.usudel(idusudel,idusu,iddealer,estado) values (?,?,?,?)";
			jdbc.update(sql,id, UsuarioDealer.getIdusu(),UsuarioDealer.getIddealer(),1);
			resp=true;
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			resp=false;
		}
		return resp;
	}

	@Override
	public UsuarioDealer getUsuarioDealerById(int id) {
		String sql;
		try {
			sql="select m.* from dealer.usudel m where m.estado=1 and m.idusudel=? ";
			UsuarioDealeraRowMapper dealeraRowMapper=new UsuarioDealeraRowMapper();
			//System.out.println("dealeraRowMapper:"+dealeraRowMapper);
			return jdbc.queryForObject(sql,dealeraRowMapper,id);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public int generarId() {
		String sql="select COALESCE(max(idusudel),0)+1 as idusudel from dealer.usudel";
		return jdbc.queryForObject(sql, Integer.class);
	}
	
	//metodos implementados
	private Usuario mgetUsuarioPersonaDealer(int idper){
		return usuarioDAO.getUsuarioPersonaDealerByIdusu(idper);
	}
	private Persona mgetPersonaUsuarioDealer(int idusu){
		return personaDAO.getPersonaUsuarioDealerByIdusu(idusu);
	}
	private Dealer mgetDealerUsuarioDealer(int iddealer) {
		//System.out.println("idDEALER:"+iddealer);
		return dealerDAO.getDealerById(iddealer);
	}
	
	public class PersonaRowMapper implements RowMapper<Persona>{
		@Override
		public Persona mapRow(ResultSet rs, int arg1) throws SQLException {
			Persona a= new Persona();
			a.setIdper(rs.getInt("idper"));
			a.setNombres(rs.getString("nombres"));
			a.setApellidos(rs.getString("apellidos"));
			a.setCi(rs.getString("ci"));
			a.setTelefono(rs.getString("telefono"));
			a.setTipo(rs.getString("tipo"));
			a.setEstado(rs.getInt("estado"));
			try {
				a.setUsuario(mgetUsuarioPersonaDealer(rs.getInt("idper")));
			} catch (Exception e) {
				a.setUsuario(null);
			}
			return a;
	    }
	}
	
	public class UsuarioDealeraRowMapper implements RowMapper<UsuarioDealer>{
		@Override
		public UsuarioDealer mapRow(ResultSet rs, int arg1) throws SQLException {
			UsuarioDealer a= new UsuarioDealer();
			a.setIdusudel(rs.getInt("idusudel"));
			a.setIdusu(rs.getInt("idusu"));
			a.setIddealer(rs.getInt("iddealer"));
			a.setEstado(rs.getInt("estado"));
			try {
				a.setPersona(mgetPersonaUsuarioDealer(rs.getInt("idusu")));
			} catch (Exception e) {
				a.setPersona(null);
			}
			try {
				a.setDealer(mgetDealerUsuarioDealer(rs.getInt("iddealer")));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				a.setDealer(null);
			}
			//System.out.println("UsuarioDealer:"+a.toString());
			return a;
	    }
	}

}
