package com.cathl.icook.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.UserDetailDAO;
import com.cathl.icook.entity.UserDetail;
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService{
	@Autowired
	UserDetailDAO userDetailDAO;
	@Override
	public Serializable createUserDetail(UserDetail newUserDetail) {
		// TODO Auto-generated method stub
		return userDetailDAO.createUserDetail(newUserDetail);
	}

}
