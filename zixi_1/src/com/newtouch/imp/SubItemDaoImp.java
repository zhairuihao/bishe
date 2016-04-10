package com.newtouch.imp;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newtouch.dao.SubItemDao;
import com.newtouch.entity.Subitem;

@SuppressWarnings("unchecked")
public class SubItemDaoImp extends HibernateDaoSupport implements SubItemDao {


	@Override
	public List<Subitem> queryAllSubItem(int itemId, int d_delete) {
		// TODO Auto-generated method stub
	
		List<Subitem>items = getHibernateTemplate().find("from Subitem where itemId=? and d_delete=?",new Object[]{itemId,d_delete});
	
		return items;
	}
	@Override
	public List<Subitem> queryAllSubItem(int itemId) {
		// TODO Auto-generated method stub
		List<Subitem>items = getHibernateTemplate().find("from Subitem where itemId=?" ,itemId);
		
		return items;
	}
	@Override
	public List<Subitem> queryAllSubItem() {
		// TODO Auto-generated method stub
        List<Subitem>items = getHibernateTemplate().find("from Subitem");
		
		return items;
	}


	@Override
	public Subitem querySubItemByName(String subItemName) {
		// TODO Auto-generated method stub
	
		List<Subitem> items = getHibernateTemplate().find("from Subitem where subitemName = ?",subItemName);
	
		if(items.size()==0)
		    return null;
		else
			return items.get(0);
	}

	@Override
	public void saveSubItem(Subitem subItem) {
		// TODO Auto-generated method stub
		System.out.println(123456);
		getHibernateTemplate().save(subItem);
	
	}

	@Override
	public void updateSubItem(int subitemId, int d_delete) {
		// TODO Auto-generated method stub
		Subitem u = new Subitem();
		u = (Subitem) getHibernateTemplate().get(Subitem.class, subitemId);
		
		u.setD_delete(d_delete);
		
		getHibernateTemplate().save(u);


	}
	@Override
	public Subitem querySubItemById(int subitemId) {
		// TODO Auto-generated method stub
		Subitem subitems = (Subitem) getHibernateTemplate().find("from Subitem where d_delete=1 and subitemId = ?",subitemId).get(0);
		return subitems;
	}


}
