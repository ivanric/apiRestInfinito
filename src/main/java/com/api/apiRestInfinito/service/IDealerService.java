package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Dealer;

public interface IDealerService {
	public List<Dealer> getListDealers();
	public boolean saveDealer(Dealer Dealer);
	public Dealer getDealerById(int id);
	public Dealer getDealerCatalogoById(int id);
}
