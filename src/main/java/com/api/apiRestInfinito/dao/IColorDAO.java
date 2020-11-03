package com.api.apiRestInfinito.dao;

import java.util.List;

import com.api.apiRestInfinito.model.Color;
import com.api.apiRestInfinito.model.Modelo;

public interface IColorDAO {
	public int generarId();
	public List<Color> getListColores();
	public boolean saveColor(Color Color);
	public Color getColorById(int id);
	public Color getColorItemById(int id);

}
