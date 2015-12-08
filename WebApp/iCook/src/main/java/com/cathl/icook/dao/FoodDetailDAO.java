package com.cathl.icook.dao;

import java.io.Serializable;
import java.util.List;

import com.cathl.icook.entity.TblFood;
import com.cathl.icook.entity.TblFoodDetail;

public interface FoodDetailDAO {
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail);
	public TblFoodDetail getFoodDetailID(int ID);
	public List<TblFoodDetail> getFoodDetail();
	public void deleteFoodDetail(int ID);
	public TblFoodDetail updateFoodDetail(TblFoodDetail newfoodDetail);
}
