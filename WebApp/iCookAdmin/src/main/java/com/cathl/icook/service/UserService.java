package com.cathl.icook.service;

import com.cathl.icook.entity.TblUser;

public interface UserService {
	public TblUser checkLogin(TblUser inputUser);
}
