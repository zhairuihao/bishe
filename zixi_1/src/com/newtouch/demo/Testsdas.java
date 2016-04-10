package com.newtouch.demo;

import com.newtouch.entity.Subitem;
import com.newtouch.entity.User;
import com.newtouch.imp.SubItemDaoImp;

import junit.framework.TestCase;

public class Testsdas extends TestCase {
	

	public void testSubitem(){
		
		SubItemDaoImp sd = new SubItemDaoImp();
		Subitem su = new Subitem();
		su.setD_delete(1);
		su.setItemDescription("11111");
		su.setItemId(1);
		su.setSubitemName("1111");
		User user = new User();
		user.setUsername("¿Ó–°≈÷");
		su.setManager(user);
		sd.saveSubItem(su);
		
	} 

}
