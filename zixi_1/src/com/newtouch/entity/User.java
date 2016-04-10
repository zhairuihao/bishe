package com.newtouch.entity;

import java.util.Date;

public class User {
	
	int userId;
	String username;
	String password;
	String sex;
	int age;
	Date birthd;//生日
	int popedom;//权限123
	int integral;//积分
	int d_delete;//删除标记1，0；
	Item item;
	
	
	public User() {
		super();
	}



	public User(int userId, String username, String password, String sex,
			int age, Date birthd, int popedom, int integral, int d_delete) {
		
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.birthd = birthd;
		this.popedom = popedom;
		this.integral = integral;
		this.d_delete = d_delete;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Date getBirthd() {
		return birthd;
	}



	public void setBirthd(Date birthd) {
		this.birthd = birthd;
	}



	public int getPopedom() {
		return popedom;
	}



	public void setPopedom(int popedom) {
		this.popedom = popedom;
	}



	public int getIntegral() {
		return integral;
	}



	public void setIntegral(int integral) {
		this.integral = integral;
	}



	public int getD_delete() {
		return d_delete;
	}



	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}
	
	
	
	
	
	

}
