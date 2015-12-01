package com.cathl.icook.dao;

import java.util.List;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblFood;

public interface FoodDAO {
	public List<Food> getFood();
	public TblFood getFoodID(int ID);
	public TblFood updateFood(TblFood newfood);
	public void deleteFood(int ID);
}
