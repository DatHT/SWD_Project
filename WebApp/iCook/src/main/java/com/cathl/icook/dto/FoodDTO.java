package com.cathl.icook.dto;

import java.io.Serializable;

import com.cathl.icook.entity.TblFood;

public class FoodDTO implements Serializable {
	private static final long serialVersionUID = -7988799579036225137L;
	
	private int foodId;
	private String foodName;
	private String description;
	private String avatarLink;
	
	public FoodDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public FoodDTO(int foodId, String foodName, String description, String avatarLink) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.description = description;
		this.avatarLink = avatarLink;
	}

	public FoodDTO(TblFood food) {
		this.foodId = food.getFoodId();
		this.foodName = food.getFoodName();
		this.description = food.getDescription();
		this.avatarLink = food.getLinkImage();
	}
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvatarLink() {
		return avatarLink;
	}
	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}
	
	
}
