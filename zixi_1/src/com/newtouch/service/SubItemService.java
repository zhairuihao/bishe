package com.newtouch.service;

import java.util.List;

import com.newtouch.entity.Subitem;

public interface SubItemService {
	
	public boolean addSubItem(Subitem subitem);
	public List<Subitem>findAllSubitem(int ItemId,int d_delete);
	public void deleteSubItem(int subitemId,int d_delete);
	public List<Subitem>findAllSubitem(int ItemId);
	public List<Subitem>findAllSubitem();
	public Subitem findSubItemById(int subitemId);
}
