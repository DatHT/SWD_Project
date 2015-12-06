package com.cathl.icook.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblFood;
import com.cathl.icook.util.HibernateUtil;

@Repository
public class FoodDAOImpl implements FoodDAO {
	
	public FoodDAOImpl() {
		System.out.println("FoodDAOImpl()");
	}

	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	public List<TblFood> getFood() {
		return hibernateUtil.fetchAll(TblFood.class);
	}

	@Override
	public TblFood getFoodID(int ID) {
		// TODO Auto-generated method stub
		return hibernateUtil.fetchById(ID, TblFood.class);
	}

	@Override
	public TblFood updateFood(TblFood newfood) {
		// TODO Auto-generated method stub
		return hibernateUtil.update(newfood);
	}

	@Override
	public void deleteFood(int ID) {
		// TODO Auto-generated method stub
		hibernateUtil.delete(ID, TblFood.class);
	}

	@Override
	public Serializable createFood(TblFood newFood) {
		// TODO Auto-generated method stub
		return hibernateUtil.create(newFood);
	}

}
