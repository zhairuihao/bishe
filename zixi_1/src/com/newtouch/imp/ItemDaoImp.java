package com.newtouch.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newtouch.dao.ItemDao;
import com.newtouch.entity.Item;
@SuppressWarnings("unchecked")
public class ItemDaoImp extends HibernateDaoSupport implements ItemDao {

	@Override
	public Item queryItemByName(String itemName) {
		// TODO Auto-generated method stub		
		List<Item>item = getHibernateTemplate().find("from Item where itemName=?",itemName);
		if(item.size()==0)return null;
		return item.get(0);
	}

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(item);

	}

	@Override
	public List<Item> queryAll() {
		// TODO Auto-generated method stub
		List<Item>item = getHibernateTemplate().find("from Item");
		return item;
			
	}

	@Override
	public void deleteItem(int itemId, int d_delete) {
		// TODO Auto-generated method stub
	      Item item = new Item();
	      item = (Item) getHibernateTemplate().get(Item.class, itemId);
	      item.setD_delete(d_delete);
		  getHibernateTemplate().save(item);
	}

	@Override
	public List<Item> queryAll(int d_delete) {
		// TODO Auto-generated method stub
		List<Item>item = getHibernateTemplate().find("from Item where d_delete = ?",d_delete);
		return item;
			
	}

}
