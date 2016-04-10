package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.Item;
import com.newtouch.entity.Subitem;
import com.newtouch.service.ItemService;
import com.newtouch.service.SubItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllSubItemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int titemId;
	private List<Subitem>subitems;
	private List<Item>items;
	private ItemService itemService;
	private SubItemService subitemService;
	
	
	public int getTitemId() {
		return titemId;
	}
	public void setTitemId(int titemId) {
		this.titemId = titemId;
	}
	public List<Subitem> getSubitems() {
		return subitems;
	}
	public void setSubitems(List<Subitem> subitems) {
		this.subitems = subitems;
	}
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
	public SubItemService getSubitemService() {
		return subitemService;
	}
	public void setSubitemService(SubItemService subitemService) {
		this.subitemService = subitemService;
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		subitems = subitemService.findAllSubitem(titemId);
		
		items = itemService.allItem();
	
		@SuppressWarnings("unchecked")
		Map<String, List<?>> session = (Map<String, List<?>>) ActionContext.getContext().getSession();	       
		session.put("allitems", items);
		session.put("allsubitems", subitems);
		return SUCCESS;
	}
	

	

}
