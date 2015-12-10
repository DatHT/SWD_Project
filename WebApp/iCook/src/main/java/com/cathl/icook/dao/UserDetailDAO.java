package com.cathl.icook.dao;

import java.io.Serializable;

import com.cathl.icook.entity.UserDetail;

public interface UserDetailDAO {
	public Serializable	createUserDetail(UserDetail newUserDetail);
}
