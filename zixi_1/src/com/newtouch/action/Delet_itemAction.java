package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.Item;
import com.newtouch.service.ItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Delet_itemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemService itemService;
    private int  itemId;
    private int d_delete;
    
    
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getD_delete() {
		return d_delete;
	}

	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	    if(d_delete==1){
	    	itemService.deleteItem(itemId, 0);
	    }else{
	    	itemService.deleteItem(itemId, 1);
	    }   	    
	    @SuppressWarnings("unchecked")
		Map<String, List<Item>> session = (Map<String, List<Item>>) ActionContext.getContext().getSession();	       
		List<Item> allitem =  itemService.allItem();
		session.put("allitems", allitem);
		return SUCCESS;
	}
	
	
}
