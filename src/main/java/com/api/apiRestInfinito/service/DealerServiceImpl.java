package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IDealerDAO;
import com.api.apiRestInfinito.model.Dealer;

@Service
public class DealerServiceImpl implements IDealerService{
	
	@Autowired
	IDealerDAO DealerDAO;

	@Override
	public List<Dealer> getListDealers() {
		// TODO Auto-generated method stub
		return DealerDAO.getListDealers();
	}

	@Override
	public boolean saveDealer(Dealer Dealer) {
		// TODO Auto-generated method stub
		return DealerDAO.saveDealer(Dealer);
	}

	@Override
	public Dealer getDealerById(int id) {
		// TODO Auto-generated method stub
		return DealerDAO.getDealerById(id);
	}

	@Override
	public Dealer getDealerCatalogoById(int id) {
		// TODO Auto-generated method stub
		return DealerDAO.getDealerCatalogoById(id);
	}
	
}
