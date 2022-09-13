package com.spring.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userlog")

public class User {
	
	@Id
	private String email;
	private String userName;
	private String password;
	private String image;
	private String mobileNo;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String userName, String password, String image, String mobileNo) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.image = image;
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + ", image=" + image
				+ ", mobileNo=" + mobileNo + "]";
	}
	
}
