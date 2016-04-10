package com.newtouch.service;

import java.util.List;

import com.newtouch.dao.TopicDao;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.Topic;
import com.newtouch.entity.User;
import com.newtouch.util.Page;
import com.newtouch.util.PageUtil;
import com.newtouch.util.Result;

public class TopicServiceImp implements TopicService {

	private TopicDao topicDao;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Override
	public Result findTopicBySubitemId(int subitemId, Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page.getEveryPage(),
				topicDao.queryTopicCount(subitemId, 1), page.getCurrentPage());
		List<Topic> topics = topicDao.queryTopicBySubitemId(subitemId, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(topics);
		return result;
	}

	@Override
	public Result findTopicBySubitemId(int subitemId, String key, Page page) {
		// TODO Auto-generated method stub
		if(key==null){
			key="";
		}
		page = PageUtil.createPage(page.getEveryPage(),
				topicDao.queryTopicCount(subitemId, 1), page.getCurrentPage());
		List<Topic> topics = topicDao.queryTopicBySubitemId(subitemId, key, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(topics);
		return result;
	}

	@Override
	public boolean addTopic(Topic topic) {
		// TODO Auto-generated method stub
		User user = userDao.byUsername(topic.getUser().getUsername());

		if (user != null) {
			user.setIntegral(user.getIntegral() + 5);// 用户积分加5
			topic.setUser(user);
			topicDao.saveTopic(topic);
			return true;
		}
		return false;
	}

	@Override
	public Topic findTopicById(int topicId) {
		// TODO Auto-generated method stub
		return topicDao.queryTopicById(topicId, 1);
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.updateTopic(topic);
	}

}
