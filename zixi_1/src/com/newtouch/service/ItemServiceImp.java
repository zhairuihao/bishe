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
	public boolean addItem(Item item) {//������Ŀ��ҵ�񷽷�
		// TODO Auto-generated method stub
		String itemName = item.getItemName();//�����Ŀ����
		if(itemdao.queryItemByName(itemName)==null){//�ж������Ƿ�ռ��
			User user=userdao.byUsername(item.getManager().getUsername());//�����û��������û�
			if(user!=null){//�ж��û����� 
				item.setManager(user);//���ð���
				itemdao.saveItem(item);//������Ŀ
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
