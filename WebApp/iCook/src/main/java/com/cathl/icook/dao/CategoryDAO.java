package com.cathl.icook.dao;

import java.awt.List;
import java.io.Serializable;

import com.cathl.icook.entity.*;
public interface CategoryDAO {
	public java.util.List<TblCategory> getCategory();
	public Serializable createNewCatelog(TblCategory newCatelog);
}
