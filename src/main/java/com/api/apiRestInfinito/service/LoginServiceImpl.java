package com.api.apiRestInfinito.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.ILoginDAO;
@Service
public class LoginServiceImpl  implements IloginService{
	@Autowired
	private ILoginDAO loginDAO;
	
	@Override
	public Map<String, Object> getDataLogin(String mail) {
		return loginDAO.getDataLogin(mail);
	}
}
