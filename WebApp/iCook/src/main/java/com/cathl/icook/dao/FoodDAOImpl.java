package com.cathl.icook.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.Food;
import com.cathl.icook.util.HibernateUtil;

@Repository
public class FoodDAOImpl implements FoodDAO {
	
	public FoodDAOImpl() {
		System.out.println("FoodDAOImpl()");
	}

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public Food getFood(int id) {
		return hibernateUtil.fetchById(id, Food.class);
	}

}
