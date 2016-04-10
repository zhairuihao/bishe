package com.newtouch.action;

import java.util.Date;
import java.util.Map;

import com.newtouch.entity.Topic;
import com.newtouch.entity.User;
import com.newtouch.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TopicAddAction extends ActionSupport implements ModelDriven<Topic>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TopicService topicService;
    private Topic topic = new Topic();
    
    
	public TopicService getTopicService() {
		return topicService;
	}


	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Topic top = new Topic();
		top.setTitle(topic.getTitle());
		top.setContent(topic.getContent());
		top.setDate(new Date());
		top.setHasread(0);
		top.setSubitemId(topic.getSubitemId());
		top.setD_delete(1);
		User user = new User();
		Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();
		user.setUsername(session.get("user_admin").getUsername());
		top.setUser(user);
		if(topicService.addTopic(top)){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
	}


	@Override
	public Topic getModel() {
		// TODO Auto-generated method stub
		return topic;
	}
}
