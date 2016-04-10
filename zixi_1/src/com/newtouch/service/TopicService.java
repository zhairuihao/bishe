package com.newtouch.service;

import com.newtouch.entity.Topic;
import com.newtouch.util.Page;
import com.newtouch.util.Result;


public interface TopicService {
  
	public Result findTopicBySubitemId(int subitemId, Page page);
	public Result findTopicBySubitemId(int subitemId,String key, Page page);
	public boolean addTopic(Topic topic);
	public Topic findTopicById(int topicId);
	public void updateTopic(Topic topic);
	
}
