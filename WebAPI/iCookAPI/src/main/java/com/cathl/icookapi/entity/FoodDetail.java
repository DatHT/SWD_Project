package com.cathl.icookapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fooddetail")
public class FoodDetail implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	@Id
	@Column(name = "FoodID")
	private int foodId;
	
	@Column(name = "MaterialDetail")
	private String materialDetail;
	
	@Column(name = "Tutorial")
	private String tutorial;
	
	@Column(name = "Source")
	private String source;
	
	@Column(name = "UserID")
	private String userId;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getMaterialDetail() {
		return materialDetail;
	}

	public void setMaterialDetail(String materialDetail) {
		this.materialDetail = materialDetail;
	}

	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
