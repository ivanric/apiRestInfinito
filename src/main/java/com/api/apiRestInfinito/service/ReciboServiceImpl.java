package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IReciboDAO;
import com.api.apiRestInfinito.model.Recibo;

@Service
public class ReciboServiceImpl implements IReciboService{
	
	@Autowired
	IReciboDAO ReciboDAO;
	
	@Override
	public List<Recibo> getListRecibos() {
		// TODO Auto-generated method stub
		return ReciboDAO.getListRecibos();
	}

	@Override
	public boolean saveRecibo(Recibo Recibo) {
		// TODO Auto-generated method stub
		return ReciboDAO.saveRecibo(Recibo);
	}

	@Override
	public Recibo getReciboById(int id) {
		// TODO Auto-generated method stub
		return ReciboDAO.getReciboById(id);
	}

	@Override
	public List<Recibo> getListReciboSolicitudItemById(int id) {
		return ReciboDAO.getListReciboSolicitudItemById(id);
	}



}
