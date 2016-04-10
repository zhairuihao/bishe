package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Item;

public interface ItemDao {

	public Item queryItemByName(String itemName);//根据栏目名查询栏目
	public void saveItem(Item item);//保存栏目方法
	public List<Item> queryAll();//查询所有的栏目
	public void deleteItem(int itemId ,int d_delete);//根据id 跟新字段d_delete
	public List<Item> queryAll(int d_delete);//查询所有没被删的栏目
}
