package com.cathl.icookapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icookapi.entity.Food;
import com.cathl.icookapi.util.ConstantDataManager;
import com.cathl.icookapi.util.HibernateUtil;

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

	@Override
	public List<Food> searchByMaterial(String materials, int start, int limit) {
		String[] searchs = materials.split("-");
		if (searchs.length > 0) {
			String query = String.format(" WHERE listMaterial LIKE '%s'", ("%" + searchs[0] + "%"));
			for (int i = 1; i < searchs.length; i++) {
				String tmp = String.format(" AND listMaterial LIKE '%s'", ("%" + searchs[i] + "%"));
				query += tmp;
			}
			query += " ORDER BY visitNum DESC";
			System.out.println(query);
			return hibernateUtil.fetchAllByQuery(query, start, limit, Food.class);
		}
		return null;		
	}

	@Override
	public Food incrVisitNum(int id) {
		Food food = hibernateUtil.fetchById(id, Food.class);
		food.setVisitNum(food.getVisitNum() + 1);
		return hibernateUtil.update(food);
	}

}
