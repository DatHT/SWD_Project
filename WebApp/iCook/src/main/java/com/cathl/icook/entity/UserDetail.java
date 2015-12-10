package com.cathl.icook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_userdetail", catalog = "icookdb")
public class UserDetail {

	@Id
	@Column(name="UserID",nullable= false)
	String userID;
	@Column(name = "FullName")
	String fullName;
	@Column(name="Phone")
	String phoneNum;
	@Column(name="Email")
	String email;
	
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetail(String userID, String fullName, String phoneNum, String email) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
