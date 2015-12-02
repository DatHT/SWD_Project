package com.cathl.icook.service;

import java.io.Serializable;
import java.util.List;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblFood;

public interface FoodService {
	public Serializable createFood(TblFood newFood);
	public List<TblFood> getFood();
	public TblFood getFoodID(int ID);
	public TblFood updateFood(TblFood newfood);
	public void deleteFood(int ID);
}
