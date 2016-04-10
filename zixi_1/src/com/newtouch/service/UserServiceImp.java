package com.newtouch.service;

import java.util.List;

import com.newtouch.dao.UserDao;
import com.newtouch.entity.User;

public class UserServiceImp implements UserService {

	
	private UserDao userdao; 
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		
		if(userdao.byUsername(username)==null) { 
			
			userdao.saveUser(user);return true;
			
		} else  { return false; }
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userdao.queryAll();
	}
	
	@Override
	public List<User> queryAll(int popedom) {
		// TODO Auto-generated method stub	
		
		return userdao.queryAll(popedom);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int userId, int d_delete) {
		// TODO Auto-generated method stub
		
		userdao.deleteUser(userId, d_delete);
		
	}

	@Override
	public int byUsername(String username,String password) {
		// TODO Auto-generated method stub
		User user = userdao.byUsername(username, password);
		if(user!=null && user.getD_delete()==1){
			if(user.getPopedom()>3){return 1;}
			return 2;
		}else{
		    return 3;
		    }
	}

	@Override
	public User byUsername(String username) {
		// TODO Auto-generated method stub
		return userdao.byUsername(username);
	}


}
