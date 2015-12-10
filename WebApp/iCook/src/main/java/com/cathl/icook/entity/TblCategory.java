package com.cathl.icook.entity;
// Generated Nov 28, 2015 4:05:49 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * TblCategory generated by hbm2java
 */
@Entity
@Table(name = "tbl_category", catalog = "icookdb")
public class TblCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451544619500751069L;
	private Integer categoryId;
	private String categoryName;
	

	public TblCategory() {
	}

	public TblCategory(String categoryName) {
		this.categoryName = categoryName;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CategoryID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CategoryName", nullable = false, length = 500)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



}
