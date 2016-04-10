package com.newtouch.action;

import java.util.Map;

import com.newtouch.entity.Subitem;
import com.newtouch.entity.User;
import com.newtouch.service.SubItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class SubItemAddAction extends ActionSupport  implements ModelDriven<Subitem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Subitem subitem = new Subitem();
	private SubItemService subitemService;


	public Subitem getSubitem() {
		return subitem;
	}


	public void setSubitem(Subitem subitem) {
		this.subitem = subitem;
	}


	public SubItemService getSubitemService() {
		return subitemService;
	}


	public void setSubitemService(SubItemService subitemService) {
		this.subitemService = subitemService;
	}


	
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();	  
		Subitem sub= new Subitem();
		sub.setSubitemName(subitem.getSubitemName());
		sub.setD_delete(1);
		sub.setItemDescription(subitem.getItemDescription());
		sub.setItemId(subitem.getItemId());
		User user = new User();
		user.setUsername(session.get("user_admin").getUsername());
		sub.setManager(user);
		
		if(subitemService.addSubItem(sub)){
			this.addActionMessage("保存成功！");
		}else{
			this.addActionMessage("保存失败！");
		}
		return SUCCESS;
	}


	@Override
	public Subitem getModel() {
		// TODO Auto-generated method stub
		return subitem;
	}
	
	

}
