package com.newtouch.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.newtouch.entity.Subitem;
import com.newtouch.entity.Topic;
import com.newtouch.service.SubItemService;
import com.newtouch.service.TopicService;
import com.newtouch.util.JsonUtil;
import com.newtouch.util.Page;
import com.newtouch.util.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllTopic_AjaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int subitemId;
	private List<Topic> allTopics;
	private String subitemName;
	private String key;
	private int currentPage;
	private Page page;
	private TopicService topicService;
	private SubItemService subitemService;
	private String json;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getSubitemId() {
		return subitemId;
	}

	public void setSubitemId(int subitemId) {
		this.subitemId = subitemId;
	}

	public List<Topic> getAllTopics() {
		return allTopics;
	}

	public void setAllTopics(List<Topic> allTopics) {
		this.allTopics = allTopics;
	}

	public String getSubitemName() {
		return subitemName;
	}

	public void setSubitemName(String subitemName) {
		this.subitemName = subitemName;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public SubItemService getSubitemService() {
		return subitemService;
	}

	public void setSubitemService(SubItemService subitemService) {
		this.subitemService = subitemService;
	}

	@SuppressWarnings("unchecked")
	public String getList() throws Exception {
		// TODO Auto-generated method stub
		Page zpage = new Page();

		zpage.setCurrentPage(currentPage);
		zpage.setEveryPage(7);
		Subitem sub = subitemService.findSubItemById(subitemId);
		subitemName = sub.getSubitemName();
		Result result = topicService
				.findTopicBySubitemId(subitemId, key, zpage);
		page = result.getPage();
		allTopics = result.getList();

		// 数据格式转换
		
		json = JsonUtil.list2json(allTopics);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("page", page);
		session.put("allTopics", allTopics);
		session.put("allTopics_json", json);
		session.put("subitem", sub);

		System.out.println(json);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
		return SUCCESS;
	}

}
