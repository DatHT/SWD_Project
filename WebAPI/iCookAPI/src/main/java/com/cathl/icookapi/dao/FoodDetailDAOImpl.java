package com.cathl.icookapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icookapi.entity.Food;
import com.cathl.icookapi.entity.FoodDetail;
import com.cathl.icookapi.util.HibernateUtil;

@Repository
public class FoodDetailDAOImpl implements FoodDetailDAO {

	public FoodDetailDAOImpl() {
		System.out.println("FoodDetailDAOImpl()");
	}
	
	@Autowired
	private HibernateUtil hibernateUtil;
	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public FoodDetail getFood(int id) {
		Food food = foodDAO.incrVisitNum(id);
		if (food == null) {
			System.out.println("Error incrVisitNum!");
		}
		return hibernateUtil.fetchById(id, FoodDetail.class);
	}
}
