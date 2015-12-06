package com.cathl.icookapi.dto;

import java.io.Serializable;

import com.cathl.icookapi.entity.FoodDetail;

public class FoodDetailDTO implements Serializable {
	private static final long serialVersionUID = -7988799579036225137L;
	private int foodId;
	private String materialDetail;
	private String tutorial;
	private String source;
	
	public FoodDetailDTO() {
		System.out.println("FoodDetailDTO()");
	}

	public FoodDetailDTO(int foodId, String materialDetail, String tutorial, String source) {
		this.foodId = foodId;
		this.materialDetail = materialDetail;
		this.tutorial = tutorial;
		this.source = source;
	}
	
	public FoodDetailDTO(FoodDetail food) {
		this.foodId = food.getFoodId();
		this.materialDetail = food.getMaterialDetail();
		this.tutorial = food.getTutorial();
		this.source = food.getSource();
	}

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

}
