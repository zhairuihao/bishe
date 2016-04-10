package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Subitem;

public interface SubItemDao {
	
	public List<Subitem> queryAllSubItem(int itemId,int d_delete);//查询指定栏目下的子栏目
	public List<Subitem> queryAllSubItem(int itemId);
	public List<Subitem> queryAllSubItem();
	public Subitem querySubItemById(int subitemId);
	public Subitem querySubItemByName(String subItemName);//根据名称查询
	public void saveSubItem(Subitem subItem);//保存栏目
	public void updateSubItem(int subitemId ,int d_delete); //更新栏目
	

}
