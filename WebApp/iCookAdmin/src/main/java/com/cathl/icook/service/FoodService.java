package com.cathl.icook.service;

import java.util.List;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblFood;

public interface FoodService {

	public List<Food> getFood();
	public TblFood getFoodID(int ID);
	public TblFood updateFood(TblFood newfood);
	public void deleteFood(int ID);
}
