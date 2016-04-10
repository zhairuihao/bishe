package com.newtouch.action;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAddAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性 
	 * 值可任意给
	 */
	private static final long serialVersionUID = 1L;

	 User user = new User();
	
	private UserService userservice;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserService getUserservice() {
		return userservice;
	}


	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 1  2  3
		 * 只能注册普通用户
		 * 初始积分为0
		 * 1
		 */
		
		user.setPopedom(1);
		user.setIntegral(0);
		user.setD_delete(1);
		
		if("1".equals(user.getSex())){user.setSex("男");}else{user.setSex("女");}
		System.out.println(user.getSex());
		
		if(userservice.addUser(user))
		{
		  this.addActionMessage("添加用户成功！");
		  System.out.println("1111111");
		  return SUCCESS;
		  }
		else{
		this.addActionMessage("该用户已存在！！");
		
		System.out.println("2222");
		return ERROR;
		}
	
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
    
	
	
}
