package com.newtouch.action;

import java.net.URLDecoder;
import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindUsernameAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private UserService userservice;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		username = URLDecoder.decode(username, "UTF-8");
		username = URLDecoder.decode(username, "UTF-8");
		username = URLDecoder.decode(username, "UTF-8");
		User user = userservice.byUsername(username);
		 @SuppressWarnings("unchecked")
		Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();	       
		session.put("byusername", user);
		return super.execute();
	}
	

}
