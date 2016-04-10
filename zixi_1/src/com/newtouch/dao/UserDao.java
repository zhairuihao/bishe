package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.User;

public interface UserDao {
	
	public void saveUser (User user);
	
	public User byUsername(String username);
	
	public User byUsername(String username,String password);
	
	public List<User> queryAll(int popedom);
	
	public void updateUser(int userId ,int popedom);
	
	public void updateUser(User user);
	
	public void deleteUser(int userId ,int d_delete);
	
	public List<User> queryAll();

}
