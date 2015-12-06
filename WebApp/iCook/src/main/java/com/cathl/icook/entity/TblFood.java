package com.cathl.icook.entity;
// Generated Nov 28, 2015 4:05:49 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TblFood generated by hbm2java
 */
@Entity
@Table(name = "tbl_food", catalog = "icookdb")
public class TblFood implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1451482429848504203L;
	private Integer foodId;
	@Column(name = "CategoryID")
	private int categoryId;
	private String foodName;
	private String description;
	private String linkImage;
	private String listMaterial;
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	private Integer visitNum;
	

	public TblFood() {
	}

	public TblFood(int categoryId, String foodName, String description, String linkImage,
			String listMaterial,Integer visitNum) {
		this.categoryId=categoryId;
		this.foodName = foodName;
		this.description = description;
		this.linkImage = linkImage;
		this.listMaterial = listMaterial;

	}



	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "FoodID", unique = true, nullable = false)
	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}



	@Column(name = "FoodName", nullable = false, length = 500)
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}




	@Column(name = "Description", nullable = false, length = 8000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "AvatarLink", nullable = false)
	public String getLinkImage() {
		return this.linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	@Column(name = "ListMaterial", nullable = false, length = 2000)
	public String getListMaterial() {
		return this.listMaterial;
	}

	public void setListMaterial(String listMaterial) {
		this.listMaterial = listMaterial;
	}


	

	@Column(name = "VisitNum")
	public Integer getVisitNum() {
		return this.visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}



}