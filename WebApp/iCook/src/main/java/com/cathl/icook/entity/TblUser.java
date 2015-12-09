package com.cathl.icook.entity;
// Generated Nov 28, 2015 4:05:49 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblUser generated by hbm2java
 */
@Entity
@Table(name = "tbl_user", catalog = "icookdb")
public class TblUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4320615272577209139L;

	private String userName;
	private String password;
	@Column(name="Role")
	private Integer role;

	public TblUser() {
	}

	public TblUser(String userName, String password, Integer role) {

		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Id
	@Column(name = "UserName", unique = true, nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
