package com.newtouch.action;



import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	private UserService  userService;
	
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		if(userService.byUsername(user.getUsername(), user.getPassword())==1){	
			Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();	       
		    User user1 = userService.byUsername(user.getUsername());
		    session.put("user_admin",user1 );
		   return SUCCESS;
		}else{
			return ERROR;
		}
	}



	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
