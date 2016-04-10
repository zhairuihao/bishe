package com.newtouch.action;

import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateuserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private User user = new User();
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
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<?, ?> session = (Map<?, ?>) ActionContext.getContext().getSession();	       
		User user1 = (User) session.get("byusername");
		user.setUserId(user1.getUserId());
		user.setBirthd(user1.getBirthd());
		user.setD_delete(user1.getD_delete());
		user.setSex(user1.getSex());
	    userservice.updateUser(user);
		return super.execute();
	}
	
	

}
