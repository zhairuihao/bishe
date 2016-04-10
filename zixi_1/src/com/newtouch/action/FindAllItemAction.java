package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.Item;
import com.newtouch.service.ItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllItemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Item>items;
	private ItemService itemService;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
  public String execute() throws Exception{
	  
	  items = itemService.allItem();//查询所有栏目
	  @SuppressWarnings("unchecked")
		Map<String, List<Item>> session = (Map<String, List<Item>>) ActionContext.getContext().getSession();	       
		session.put("allitems", items);
	return SUCCESS;
	  
  }

}
