package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Item;

public interface ItemDao {

	public Item queryItemByName(String itemName);//������Ŀ����ѯ��Ŀ
	public void saveItem(Item item);//������Ŀ����
	public List<Item> queryAll();//��ѯ���е���Ŀ
	public void deleteItem(int itemId ,int d_delete);//����id �����ֶ�d_delete
	public List<Item> queryAll(int d_delete);//��ѯ����û��ɾ����Ŀ
}
