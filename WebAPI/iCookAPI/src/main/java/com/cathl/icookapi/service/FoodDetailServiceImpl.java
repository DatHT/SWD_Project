package com.cathl.icookapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icookapi.dao.FoodDetailDAO;
import com.cathl.icookapi.entity.FoodDetail;

@Service
@Transactional
public class FoodDetailServiceImpl implements FoodDetailService {

	public FoodDetailServiceImpl() {
		System.out.println("FoodDetailServiceImpl()");
	}
	
	@Autowired
	private FoodDetailDAO foodDetailDAO;
	
	@Override
	public FoodDetail getFood(int id) {
		return foodDetailDAO.getFood(id);
	}

}
