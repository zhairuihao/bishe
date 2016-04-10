package com.newtouch.intercept;

import java.util.Map;

import com.newtouch.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录用户权限控制
 * @author zrhax
 *
 */
public class PowerInterceprt extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//ActionSupport ac=(ActionSupport)arg0.getAction();
		
		 @SuppressWarnings("rawtypes")
		Map session = arg0.getInvocationContext().getSession();  
		 //获取登录用户的信息
		 User user = (User) session.get("user_admin");  
		 /**
		  * 4-->>管理员
		  * 3-->>版主
		  * 2-->>小版主
		  * 1-->>普通用户
		  */
		 if(user.getPopedom()>3){
			 return arg0.invoke();
		 }
	     return Action.ERROR;
	}

}
