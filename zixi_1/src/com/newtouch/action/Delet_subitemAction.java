package com.newtouch.action;

import java.util.List;
import java.util.Map;


import com.newtouch.entity.Subitem;
import com.newtouch.service.SubItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Delet_subitemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int subitemId;
	private int d_delete;
	private int itemId;
	private SubItemService subitemService;
	
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public SubItemService getSubitemService() {
		return subitemService;
	}
	public void setSubitemService(SubItemService subitemService) {
		this.subitemService = subitemService;
	}
	public int getSubitemId() {
		return subitemId;
	}
	public void setSubitemId(int subitemId) {
		this.subitemId = subitemId;
	}
	public int getD_delete() {
		return d_delete;
	}
	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("111111111");
	    if(d_delete==1){
	    	System.out.println("2222222222");
	    	subitemService.deleteSubItem(subitemId, 0);
	    }else{
	    	System.out.println("3333333333333");
	    	subitemService.deleteSubItem(subitemId, 1);
	    }   	    
	    @SuppressWarnings("unchecked")
		Map<String, List<Subitem>> session = (Map<String, List<Subitem>>) ActionContext.getContext().getSession();	       
		List<Subitem> allitem =  subitemService.findAllSubitem(itemId);
		session.put("allsubitems", allitem);
		return SUCCESS;
	}
	
	

}
