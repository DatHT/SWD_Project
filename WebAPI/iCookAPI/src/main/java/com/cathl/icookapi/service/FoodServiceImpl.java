package com.cathl.icookapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icookapi.dao.FoodDAO;
import com.cathl.icookapi.entity.Food;

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

	@Override
	public List<Food> searchByMaterial(String materials, int start, int limit) {
		return foodDAO.searchByMaterial(materials, start, limit);
	}

}
