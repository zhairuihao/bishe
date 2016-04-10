package com.newtouch.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RegistIntercept extends AbstractInterceptor  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionSupport ac=(ActionSupport)arg0.getAction();
		
	     ac.clearErrorsAndMessages();
	     
	     return arg0.invoke();
	}

}