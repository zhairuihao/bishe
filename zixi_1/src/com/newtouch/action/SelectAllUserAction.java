package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SelectAllUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private UserService userservice;
    
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<User> userlist = userservice.queryAll();
		 @SuppressWarnings("unchecked")
		Map<String, List<User>> session = (Map<String, List<User>>) ActionContext.getContext().getSession();	       
		session.put("userlist", userlist);
		
		return super.execute();
	}

	
}
