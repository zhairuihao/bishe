package com.newtouch.action;


import java.util.Map;

import com.newtouch.entity.Item;
import com.newtouch.entity.User;
import com.newtouch.service.ItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ItemAddAction extends ActionSupport implements ModelDriven<Item>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Item item = new Item();
	private ItemService itemService;
	
	
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public ItemService getItemService() {
		return itemService;
	}


	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}


	@SuppressWarnings("unchecked" )
	public String execute() throws Exception {
		Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();	       
		Item item1 = new Item();
		item1.setItemName(item.getItemName());
		item1.setItemDescript(item.getItemDescript());
		item1.setD_delete(1);
		User user = new User();
		user.setUsername(session.get("user_admin").getUsername());
		item1.setManager(user);
		
		if(itemService.addItem(item1)){
			this.addActionMessage("添加成功");
			
		}else{
			this.addActionMessage("栏目已占用或版主不存在");
		}
		return SUCCESS;
	}
	@Override
	public Item getModel() {
		// TODO Auto-generated method stub
		return item;
	}

	
}
