package com.cathl.icook.dao;

import java.io.Serializable;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.TblFoodDetail;
import com.cathl.icook.util.HibernateUtil;
@Repository
public class FoodDetailDAOIml implements FoodDetailDAO{
	@Autowired
	HibernateUtil hibernateUltil;
	@Override
	public TblFoodDetail getFoodDetailID(int ID) {
		// TODO Auto-generated method stub
		return hibernateUltil.fetchById(ID, TblFoodDetail.class);
	}
	@Override
	public void deleteFoodDetail(int ID) {
		// TODO Auto-generated method stub
		hibernateUltil.delete(ID, TblFoodDetail.class);
	}
	@Override
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail) {
		// TODO Auto-generated method stub
		return hibernateUltil.create(newFoodDetail);
	}

}
