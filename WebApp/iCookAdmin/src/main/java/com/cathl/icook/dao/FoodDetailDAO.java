package com.cathl.icook.dao;

import java.io.Serializable;

import com.cathl.icook.entity.TblFoodDetail;

public interface FoodDetailDAO {
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail);
	public TblFoodDetail getFoodDetailID(int ID);
	public void deleteFoodDetail(int ID);
}
