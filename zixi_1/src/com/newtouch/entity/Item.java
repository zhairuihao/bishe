package com.newtouch.entity;

import java.util.Set;

public class Item {
	
	
       int  itemId;
       String itemName;//栏目名
       String itemDescript;//栏目介绍
       User manager;//栏目的版主
       int d_delete;//删除标记
       Set<Subitem> sub;
       
       
       
       
	public Item() {
		super();
	}
	public Item(int itemId, String itemName, String itemDescript, User manager,
			int d_delete) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescript = itemDescript;
		this.manager = manager;
		this.d_delete = d_delete;
	}
	
	
	

	public Set<Subitem> getSub() {
		return sub;
	}
	public void setSub(Set<Subitem> sub) {
		this.sub = sub;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescript() {
		return itemDescript;
	}
	public void setItemDescript(String itemDescript) {
		this.itemDescript = itemDescript;
	}

	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public int getD_delete() {
		return d_delete;
	}
	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}
       
       
       

}
