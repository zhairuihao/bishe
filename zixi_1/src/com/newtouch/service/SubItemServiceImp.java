package com.newtouch.service;

import java.util.List;

import com.newtouch.dao.SubItemDao;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.Subitem;
import com.newtouch.entity.User;

public class SubItemServiceImp implements SubItemService {
	
	private SubItemDao subItemDao;
	private UserDao userDao;
	

	public SubItemDao getSubItemDao() {
		return subItemDao;
	}

	public void setSubItemDao(SubItemDao subItemDao) {
		this.subItemDao = subItemDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addSubItem(Subitem subitem) {
		// TODO Auto-generated method stub
		String subitemNmae = subitem.getSubitemName();
		
		
		if(subItemDao.querySubItemByName(subitemNmae)==null){		
			User user = userDao.byUsername(subitem.getManager().getUsername());	   
			if(user!=null){
		    	subitem.setManager(user);
		    	subItemDao.saveSubItem(subitem);
		    	return true;
		    }
		}
		return false;
	}

	@Override
	public List<Subitem> findAllSubitem(int ItemId, int d_delete) {
		// TODO Auto-generated method stub
	
		return subItemDao.queryAllSubItem(ItemId, d_delete);
	}
	@Override
	public List<Subitem> findAllSubitem(int ItemId) {
		// TODO Auto-generated method stub
		return subItemDao.queryAllSubItem(ItemId);
	}
	@Override
	public List<Subitem> findAllSubitem() {
		// TODO Auto-generated method stub
		return subItemDao.queryAllSubItem();
	}

	@Override
	public void deleteSubItem(int subitemId, int d_delete) {
		// TODO Auto-generated method stub
		subItemDao.updateSubItem(subitemId, d_delete);

	}

	@Override
	public Subitem findSubItemById(int subitemId) {
		// TODO Auto-generated method stub
		return subItemDao.querySubItemById(subitemId);
	}


}
