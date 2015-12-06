package com.cathl.icook.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathl.icook.dao.UserDAO;
import com.cathl.icook.entity.TblUser;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;
	@Override
	public TblUser checkLogin(TblUser inputUser) {
		// TODO Auto-generated method stub
		return userDao.checkLogin(inputUser);
	}

}
