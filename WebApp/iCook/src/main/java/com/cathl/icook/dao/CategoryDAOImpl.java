package com.cathl.icook.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.*;
import com.cathl.icook.util.*;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	HibernateUtil hibernateUltil;
	


	public CategoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("DAo");
	}



	@Override
	public List<TblCategory> getCategory() {
		// TODO Auto-generated method stub
		return hibernateUltil.fetchAll(TblCategory.class);
	}



	@Override
	public Serializable createNewCatelog(TblCategory newCatelog) {
		// TODO Auto-generated method stub
		return  hibernateUltil.create(newCatelog);
	}

}
