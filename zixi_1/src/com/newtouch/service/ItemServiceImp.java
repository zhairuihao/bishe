package com.newtouch.service;

import java.util.List;

import com.newtouch.dao.ItemDao;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.Item;
import com.newtouch.entity.User;

public class ItemServiceImp implements ItemService {

	private ItemDao itemdao;
	private UserDao userdao;
	
	

	public ItemDao getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public boolean addItem(Item item) {//增加栏目的业务方法
		// TODO Auto-generated method stub
		String itemName = item.getItemName();//获得栏目名称
		if(itemdao.queryItemByName(itemName)==null){//判断名称是否被占用
			User user=userdao.byUsername(item.getManager().getUsername());//根据用户名查找用户
			if(user!=null){//判断用户存在 
				item.setManager(user);//设置版主
				itemdao.saveItem(item);//保存栏目
				return true;
			}
			
		}
		
		return false;                                                                                                                                                                                                                                               
	}

	@Override
	public List<Item> allItem() {
		// TODO Auto-generated method stub
		return itemdao.queryAll();
	}

	@Override
	public void deleteItem(int itemId, int d_delete) {
		// TODO Auto-generated method stub
		itemdao.deleteItem(itemId, d_delete);
	}

}
