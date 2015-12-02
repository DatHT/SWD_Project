package com.cathl.icook.service;

import java.io.Serializable;

import com.cathl.icook.entity.TblFoodDetail;

public interface FoodDetailSevices {
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail);
	public TblFoodDetail getFoodDetailID(int ID);
	public void deleteFoodDetail(int ID);
}
