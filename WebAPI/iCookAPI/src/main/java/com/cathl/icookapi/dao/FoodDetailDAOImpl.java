package com.cathl.icookapi.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cathl.icookapi.entity.FoodDetail;
import com.cathl.icookapi.util.HibernateUtil;

public class FoodDetailDAOImpl implements FoodDetailDAO {

	public FoodDetailDAOImpl() {
		System.out.println("FoodDetailDAOImpl()");
	}
	
//	@Autowired
//	private HibernateUtil hibernateUtil;
//	
//	@Override
//	public FoodDetail getFood(int id) {
//		return hibernateUtil.fetchById(id, FoodDetail.class);
//	}
}
