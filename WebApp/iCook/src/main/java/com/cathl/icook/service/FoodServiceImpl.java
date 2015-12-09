package com.cathl.icook.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.FoodDAO;
import com.cathl.icook.entity.Food;
import com.cathl.icook.entity.TblFood;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	public FoodServiceImpl() {
		System.out.println("FoodServiceImpl()");
	}

	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public List<TblFood> getFood() {
		return foodDAO.getFood();
	}

	@Override
	public TblFood getFoodID(int ID) {
		// TODO Auto-generated method stub
		return foodDAO.getFoodID(ID);
	}

	@Override
	public TblFood updateFood(TblFood newfood) {
		// TODO Auto-generated method stub
		return foodDAO.updateFood(newfood);
	}

	@Override
	public void deleteFood(int ID) {
		// TODO Auto-generated method stub
		foodDAO.deleteFood(ID);
	}

	@Override
	public Serializable createFood(TblFood newFood) {
		// TODO Auto-generated method stub
		return foodDAO.createFood(newFood);
	}

	@Override
	public List<TblFood> getFoodUser(String username) {
		// TODO Auto-generated method stub
		List<TblFood> allFood =getFood();
		List<TblFood> foodUser = new ArrayList<TblFood>();
		for (TblFood tblFood : allFood) {
				if (tblFood.getUserID().equals(username)) {
					foodUser.add(tblFood);
				}
			
		}
		return foodUser;
	}

}
