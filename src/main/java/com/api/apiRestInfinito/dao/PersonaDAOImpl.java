package com.api.apiRestInfinito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.apiRestInfinito.dao.SolicitudItemDAOImpl.SolicitudItemRowMapper;
import com.api.apiRestInfinito.model.Linea;
import com.api.apiRestInfinito.model.Persona;
import com.api.apiRestInfinito.model.SolicitudItem;
import com.api.apiRestInfinito.model.Usuario;


@Transactional
@Repository
public class PersonaDAOImpl implements IPersonaDAO{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	
	@Override
	public Map<String,Object> savePersona(Persona persona) {
		
		int idper= generarIdPer();
		String sql;
		
		Map<String,Object> resp=new HashMap<String, Object>();
		
		try {
			//Add Persona
			sql = "INSERT INTO persona(idper,ci,nombres,apellidos,telefono,tipo,estado) values (?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,idper, persona.getCi(), persona.getNombres(),persona.getApellidos(),persona.getTelefono(),persona.getTipo(),1);
			
			resp.put("status",true);
			resp.put("idper",idper);
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			e.printStackTrace();
			//idper=0;
			resp.put("status",false);
			resp.put("idper",null);
		}
	
		return resp;
		//Fetch Persona id
//		sql = "SELECT idper FROM persona WHERE ci=?";
//		int PersonaIdPer = jdbcTemplate.queryForObject(sql, Integer.class, persona.getCi());
		
		//Set Persona id 
//		persona.setIdper(PersonaIdPer);
		
	}

	@Override
	public int generarIdPer() {
		String sql="select COALESCE(max(idper),0)+1 as idper from persona";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Persona getPersonaByid(int id){
		String sql;
		try {
			sql="select p.* from persona p where p.estado=1 and p.idper=? ";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Persona>(Persona.class),id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Persona getPersonaUsuarioByid(int idusu) {
		try {
			//return jdbc.query("select m.* from solicituditem m where m.aprovado=1",new BeanPropertyRowMapper<SolicitudItem>(SolicitudItem.class));
			PersonaRowMapper personaItemRowMapper=new PersonaRowMapper();	
			return jdbcTemplate.queryForObject("select p.* from persona p,usuario u  where u.idper=p.idper and  p.estado=1 and u.idusu=?",personaItemRowMapper,idusu);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Persona getPersonaUsuarioDealerByIdusu(int idusu) {
		try {
			//return jdbc.query("select m.* from solicituditem m where m.aprovado=1",new BeanPropertyRowMapper<SolicitudItem>(SolicitudItem.class));
			PersonaDealerRowMapper personaDealerItemRowMapper=new PersonaDealerRowMapper();	
			return jdbcTemplate.queryForObject("select p.* from persona p,usuario u  where u.idper=p.idper and  p.estado=1 and u.idusu=?",personaDealerItemRowMapper,idusu);
		} catch (Exception e) {//DataAccessException e
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//metodos implementados
	private Usuario mgetUsuarioPersona(int idper) {
		return usuarioDAO.getUsuarioPersonaByIdper(idper);
	}
	private Usuario mgetUsuarioPersonaDealer(int idper) {
		return usuarioDAO.getUsuarioPersonaDealerByIdusu(idper);
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
				a.setUsuario(mgetUsuarioPersona(rs.getInt("idper")));
			} catch (Exception e) {
				a.setUsuario(null);
			}
			return a;
	    }
	}
	public class PersonaDealerRowMapper implements RowMapper<Persona>{
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
}
