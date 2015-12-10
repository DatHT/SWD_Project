package com.cathl.icook.service;

import java.io.Serializable;
import java.util.List;

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
	@Override
	public Serializable createUser(TblUser newUSer) {
		// TODO Auto-generated method stub
		return userDao.createUser(newUSer);
	}
	@Override
	public TblUser checkDubplicate(String username) {
		// TODO Auto-generated method stub
		List<TblUser> listUser = userDao.getAllUser();
		for (TblUser tblUser : listUser) {
			if(tblUser.getUserName().equals(username)){
				return tblUser;
			}
		}
		return null;
	}

}
