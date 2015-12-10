package com.cathl.icook.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.UserDetail;
import com.cathl.icook.util.HibernateUtil;
@Repository
public class UserDetailDAOImpl implements UserDetailDAO{
	@Autowired
	private HibernateUtil hibernateUltil;
	@Override
	public Serializable createUserDetail(UserDetail newUserDetail) {
		// TODO Auto-generated method stub
		return hibernateUltil.create(newUserDetail);
	}

}
