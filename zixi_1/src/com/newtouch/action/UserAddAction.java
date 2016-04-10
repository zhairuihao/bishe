package com.newtouch.action;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAddAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * ���л�ʱΪ�˱��ְ汾�ļ����ԣ����ڰ汾����ʱ�����л��Ա��ֶ����Ψһ�� 
	 * ֵ�������
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
		 * ֻ��ע����ͨ�û�
		 * ��ʼ����Ϊ0
		 * 1
		 */
		
		user.setPopedom(1);
		user.setIntegral(0);
		user.setD_delete(1);
		
		if("1".equals(user.getSex())){user.setSex("��");}else{user.setSex("Ů");}
		System.out.println(user.getSex());
		
		if(userservice.addUser(user))
		{
		  this.addActionMessage("����û��ɹ���");
		  System.out.println("1111111");
		  return SUCCESS;
		  }
		else{
		this.addActionMessage("���û��Ѵ��ڣ���");
		
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
