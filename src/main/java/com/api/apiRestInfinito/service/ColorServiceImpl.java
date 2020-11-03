package com.api.apiRestInfinito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiRestInfinito.dao.IColorDAO;
import com.api.apiRestInfinito.model.Color;

@Service
public class ColorServiceImpl implements IColorService{
	
	@Autowired
	IColorDAO ColorDAO;
	
	@Override
	public List<Color> getListColores() {
		// TODO Auto-generated method stub
		return ColorDAO.getListColores();
	}

	@Override
	public boolean saveColor(Color Color) {
		// TODO Auto-generated method stub
		return ColorDAO.saveColor(Color);
	}

	@Override
	public Color getColorById(int id) {
		// TODO Auto-generated method stub
		return ColorDAO.getColorById(id);
	}

	@Override
	public Color getColorItemById(int id) {
		return ColorDAO.getColorItemById(id);
	}


}
