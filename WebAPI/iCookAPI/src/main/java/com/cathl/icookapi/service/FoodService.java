package com.cathl.icookapi.service;

import java.util.List;

import com.cathl.icookapi.entity.Food;

public interface FoodService {

	public Food getFood(int id);
	
	public List<Food> searchByMaterial(String materials, int start, int limit);
}
