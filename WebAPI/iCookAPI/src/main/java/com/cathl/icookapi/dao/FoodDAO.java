package com.cathl.icookapi.dao;

import java.util.List;

import com.cathl.icookapi.entity.Food;

public interface FoodDAO {
	public Food getFood(int id);
	public List<Food> searchByMaterial(String materials, int start, int limit);
}
