package com.api.apiRestInfinito.service;

import java.util.List;

import com.api.apiRestInfinito.model.Color;



public interface IColorService {
	public List<Color> getListColores();
	public boolean saveColor(Color Color);
	public Color getColorById(int id);
	public Color getColorItemById(int id);
	
}
