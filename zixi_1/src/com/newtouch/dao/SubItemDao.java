package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Subitem;

public interface SubItemDao {
	
	public List<Subitem> queryAllSubItem(int itemId,int d_delete);//��ѯָ����Ŀ�µ�����Ŀ
	public List<Subitem> queryAllSubItem(int itemId);
	public List<Subitem> queryAllSubItem();
	public Subitem querySubItemById(int subitemId);
	public Subitem querySubItemByName(String subItemName);//�������Ʋ�ѯ
	public void saveSubItem(Subitem subItem);//������Ŀ
	public void updateSubItem(int subitemId ,int d_delete); //������Ŀ
	

}
