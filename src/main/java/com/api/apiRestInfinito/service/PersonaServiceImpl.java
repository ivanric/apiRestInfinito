package com.api.apiRestInfinito.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IPersonaDAO;
import com.api.apiRestInfinito.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired 
	private IPersonaDAO personaDAO;
	
	@Override
	public Map<String,Object> savePersona(Persona persona) {
		Map<String,Object> respS=new HashMap<String, Object>(); 
		try {
			Map<String,Object> resp=personaDAO.savePersona(persona);
			if ((boolean)resp.get("status")) {
				respS.put("status",true);
				respS.put("idper",(Integer)resp.get("idper"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ecep:"+e.getMessage());
			respS.put("status",false);
			respS.put("idper",null);
		}
		return respS;
		
	}

	@Override
	public Persona getPersonaByid(int id) {
		// TODO Auto-generated method stub
		return personaDAO.getPersonaByid(id);
	}

	@Override
	public Persona getPersonaUsuarioByid(int idusu) {
		// TODO Auto-generated method stub
		return personaDAO.getPersonaUsuarioByid(idusu);
	}

	@Override
	public Persona getPersonaUsuarioDealerByIdusu(int idusu) {
		// TODO Auto-generated method stub
		return personaDAO.getPersonaUsuarioDealerByIdusu(idusu);
	}

}
