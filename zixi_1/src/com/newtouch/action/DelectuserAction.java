package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelectuserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int d_delete;
	private int popedom;
    private List<User> alluser;
	private UserService userservice;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getD_delete() {
		return d_delete;
	}
	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}
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
		if(d_delete==1){
			userservice.deleteUser(userId, 0);
		}else{
			
			userservice.deleteUser(userId, 1);
			}
		 @SuppressWarnings("unchecked")
		Map<String, List<User>> session = (Map<String, List<User>>) ActionContext.getContext().getSession();	       
		alluser = userservice.queryAll(popedom);
		session.put("alluser", alluser);
		return super.execute();
	}
	

}
