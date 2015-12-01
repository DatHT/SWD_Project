package com.cathl.icook.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.*;
import com.cathl.icook.entity.*;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO categoryDAO;
	@Override
	public List<TblCategory> getCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategory();
	}
	@Override
	public Serializable createNewCatelog(TblCategory newCatelog) {
		// TODO Auto-generated method stub
		return categoryDAO.createNewCatelog(newCatelog);
	}
	
}
