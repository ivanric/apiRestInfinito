package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Dealer;
public interface IDealerDAO {
	public int generarId();
	public List<Dealer> getListDealers();
	public boolean saveDealer(Dealer Dealer);
	public Dealer getDealerById(int id);
	
	
	public Dealer getDealerCatalogoById(int iddealer);
}
