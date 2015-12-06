package com.cathl.icook.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fooddetail", catalog = "icookdb")
public class TblFoodDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6339036863329627675L;
	@Id
	@Column(name="FoodID")
	private Integer foodID;
	@Column(name="MaterialDetail")
	private String materialDetail;
	@Column(name="Tutorial")
	private String tutorial;
	@Column(name="Source")
	private String source;
	@Column(name="UserID")
	private String user;
	public TblFoodDetail(Integer foodID,String materialDetail, String tutorial, String source, String user) {
		super();
		this.foodID=foodID;
		this.materialDetail = materialDetail;
		this.tutorial = tutorial;
		this.source = source;
		this.user = user;
	}
	public TblFoodDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
