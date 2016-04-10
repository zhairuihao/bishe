package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Topic;
import com.newtouch.util.Page;

public interface TopicDao {
	/**
	 * 子栏目下的主题
	 * @param subitemId     子栏目id
	 * @param page
	 * @return
	 */
	public List<Topic> queryTopicBySubitemId(int subitemId,Page page);
	public List<Topic> queryTopicBySubitemId(int subitemId,String key, Page page);
	/**
	 * 查询子栏目下的主题数量
	 * @param subitemId
	 * @param d_delete
	 * @return
	 */
	public int queryTopicCount(int subitemId ,int d_delete);
	public int queryTopicCount();
	public void saveTopic(Topic topic);
	public Topic queryTopicById(int topicId,int d_delete);
	public void updateTopic(Topic topic);
}
