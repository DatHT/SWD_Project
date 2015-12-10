package com.cathl.icook.service;

import java.io.Serializable;

import com.cathl.icook.entity.TblUser;

public interface UserService {
	public TblUser checkLogin(TblUser inputUser);
	public Serializable createUser(TblUser newUSer);
	public TblUser checkDubplicate(String username);
}
