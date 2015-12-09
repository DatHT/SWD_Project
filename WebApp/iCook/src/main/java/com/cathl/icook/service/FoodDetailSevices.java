package com.cathl.icook.service;

import java.io.Serializable;
import java.util.List;

import com.cathl.icook.entity.TblFoodDetail;

public interface FoodDetailSevices {
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail);
	public List<Integer> getFoodDetailuser(String username);
	public TblFoodDetail getFoodDetailID(int ID);
	public List<TblFoodDetail> getFoodDetail();
	public void deleteFoodDetail(int ID);
	public TblFoodDetail updateFoodDetail(TblFoodDetail newfoodDetail);
}
