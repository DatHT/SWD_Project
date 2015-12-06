package com.cathl.icook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathl.icook.entity.TblUser;
import com.cathl.icook.util.HibernateUtil;
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private HibernateUtil hibernateUltil;
	@Override
	public TblUser checkLogin(TblUser inputUser) {
		// TODO Auto-generated method stub
		List<TblUser> allUserLst = getAllUser();
		for (TblUser tblUser : allUserLst) {
			if (tblUser.getUserName().equals(inputUser.getUserName())&&
					tblUser.getPassword().equals(inputUser.getPassword())) {
				return tblUser;
			}
		}
		return null;
	}

	@Override
	public List<TblUser> getAllUser() {
		// TODO Auto-generated method stub
		return hibernateUltil.fetchAll(TblUser.class);
	}

}
