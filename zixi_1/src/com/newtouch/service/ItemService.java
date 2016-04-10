package com.newtouch.service;

import java.util.List;

import com.newtouch.entity.Item;

public interface ItemService {

	public boolean addItem(Item item);
	
	public List<Item> allItem();
	
	public void deleteItem(int itemId, int d_delete);
}
