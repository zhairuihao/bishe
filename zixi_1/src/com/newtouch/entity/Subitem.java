package com.newtouch.entity;

import java.util.Set;

public class Subitem {
	
	int subitemId;
	String subitemName;
	int itemId;
	String itemDescription;
	User manager;
	int d_delete;//É¾³ý±ê¼Ç
	Set <Topic> topic;
	
	
	
	
	public Subitem() {
		super();
	}
	public Subitem(int subitemId, String subitemName, int itemId,
			String itemDescription, User manager, int d_delete) {
		super();
		this.subitemId = subitemId;
		this.subitemName = subitemName;
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.manager = manager;
		this.d_delete = d_delete;
	}
	
	public int getSubitemId() {
		return subitemId;
	}
	public void setSubitemId(int subitemId) {
		this.subitemId = subitemId;
	}
	public String getSubitemName() {
		return subitemName;
	}
	public void setSubitemName(String subitemName) {
		this.subitemName = subitemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
	public Set<Topic> getTopic() {
		return topic;
	}
	public void setTopic(Set<Topic> topic) {
		this.topic = topic;
	}
	   
	
	
	   
	

}
