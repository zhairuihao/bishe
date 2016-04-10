package com.newtouch.service;

import java.util.List;

import com.newtouch.entity.User;

public interface UserService {

	public boolean addUser(User user);
	
	public int byUsername(String username,String password);
	
	public User byUsername(String username);
	
    public List<User> queryAll(int popedom);
	
	public void updateUser(User user);
	
	public void deleteUser(int userId ,int d_delete);
	
	public List<User> queryAll();
	
	
	
}
