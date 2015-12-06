package com.cathl.icookapi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cathl.icookapi.dao.FoodDetailDAO;
import com.cathl.icookapi.entity.FoodDetail;

public class FoodDetailServiceImpl implements FoodDetailService {

	public FoodDetailServiceImpl() {
		System.out.println("FoodDetailServiceImpl()");
	}
	
//	@Autowired
//	private FoodDetailDAO foodDetailDAO;
//	
//	@Override
//	public FoodDetail getFood(int id) {
//		return foodDetailDAO.getFood(id);
//	}

}
