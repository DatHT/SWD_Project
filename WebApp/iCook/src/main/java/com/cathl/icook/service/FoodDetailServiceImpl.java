package com.cathl.icook.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.FoodDetailDAO;
import com.cathl.icook.entity.TblFoodDetail;

@Service
@Transactional
public class FoodDetailServiceImpl implements FoodDetailSevices {

	@Autowired
	FoodDetailDAO foodDetailDAO;

	@Override
	public TblFoodDetail getFoodDetailID(int ID) {
		// TODO Auto-generated method stub
		return foodDetailDAO.getFoodDetailID(ID);
	}

	@Override
	public void deleteFoodDetail(int ID) {
		// TODO Auto-generated method stub
		foodDetailDAO.deleteFoodDetail(ID);
	}

	@Override
	public Serializable createFoodDetail(TblFoodDetail newFoodDetail) {
		// TODO Auto-generated method stub
		return foodDetailDAO.createFoodDetail(newFoodDetail);
	}

	@Override
	public TblFoodDetail updateFoodDetail(TblFoodDetail newfoodDetail) {
		// TODO Auto-generated method stub
		return foodDetailDAO.updateFoodDetail(newfoodDetail);
	}

	@Override
	public List<Integer> getFoodDetailuser(String username) {
		// TODO Auto-generated method stub
		List<TblFoodDetail> allFoodDetail = getFoodDetail();
		List<Integer> listFoodDetailUser = new ArrayList<Integer>();
		for (TblFoodDetail tblFoodDetail : allFoodDetail) {
			if (tblFoodDetail.getUser().equals(username)) {
				listFoodDetailUser.add(tblFoodDetail.getFoodID());
			}
		}
		return listFoodDetailUser;
	}

	@Override
	public List<TblFoodDetail> getFoodDetail() {
		// TODO Auto-generated method stub
		return foodDetailDAO.getFoodDetail();
	}

}
