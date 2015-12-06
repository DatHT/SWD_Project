package com.cathl.icook.dao;

import java.util.List;

import com.cathl.icook.entity.TblUser;

public interface UserDAO {
	public List<TblUser> getAllUser();
	public TblUser checkLogin(TblUser inputUser);
}
