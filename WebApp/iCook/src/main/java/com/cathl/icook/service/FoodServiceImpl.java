package com.cathl.icook.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.FoodDAO;
import com.cathl.icook.entity.Food;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	public FoodServiceImpl() {
		System.out.println("FoodServiceImpl()");
	}

	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public Food getFood(int id) {
		return foodDAO.getFood(id);
	}

}
