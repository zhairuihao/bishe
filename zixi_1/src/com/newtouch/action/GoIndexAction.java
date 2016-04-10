package com.newtouch.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newtouch.entity.Item;
import com.newtouch.entity.Subitem;
import com.newtouch.service.ItemService;
import com.newtouch.service.SubItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("rawtypes")
public class GoIndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Subitem>subitems;
	private List<Item>items;
	
	private Map<Item,List>map;//栏目下的子栏目
	private ItemService itemService;
	private SubItemService subitemService;
	public List<Subitem> getSubitems() {
		
		return subitems;
	}
	public void setSubitems(List<Subitem> subitems) {
		this.subitems = subitems;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Map<Item, List> getMap() {
		return map;
	}
	public void setMap(Map<Item, List> map) {
		this.map = map;
	}
	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public SubItemService getSubitemService() {
		return subitemService;
	}
	public void setSubitemService(SubItemService subitemService) {
		this.subitemService = subitemService;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		items = itemService.allItem();
		//创建一个Map来存放栏目下的子栏目
		List<Subitem>subitems1 = subitemService.findAllSubitem();
		map = new HashMap<Item,List>();
		for(Item item:items){
		
			subitems = subitemService.findAllSubitem(item.getItemId(),1);
			
			map.put(item, subitems);//获取子栏目放置到map中
			/*System.out.println(item.getItemName());
			if(map.get(item)!=null){
			 for(int i=0;i<map.get(item).size();i++){
				 Subitem su = (Subitem) map.get(item).get(i);
				 System.out.println(su.getSubitemName());
			 }	      
			}*/
		
		}
		Map session = (Map) ActionContext.getContext().getSession();	       
		session.put("a_subitem", map);
		session.put("subitems1", subitems1);
		return SUCCESS;
	}
	
	
	
	
}
