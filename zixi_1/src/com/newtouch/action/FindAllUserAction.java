package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private UserService userservice;
    private int popedom;
    private List<User> alluser;
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public int getPopedom() {
		return popedom;
	}
	public void setPopedom(int popedom) {
		this.popedom = popedom;
	}
	public List<User> getAlluser() {
		return alluser;
	}
	public void setAlluser(List<User> alluser) {
		this.alluser = alluser;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 @SuppressWarnings("unchecked")
		Map<String, List<User>> session = (Map<String, List<User>>) ActionContext.getContext().getSession();	       
		alluser = userservice.queryAll(popedom);
		session.put("alluser", alluser);
		return SUCCESS;
	}
    
    
    
}
