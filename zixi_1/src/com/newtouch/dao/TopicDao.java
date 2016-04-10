package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Topic;
import com.newtouch.util.Page;

public interface TopicDao {
	/**
	 * ����Ŀ�µ�����
	 * @param subitemId     ����Ŀid
	 * @param page
	 * @return
	 */
	public List<Topic> queryTopicBySubitemId(int subitemId,Page page);
	public List<Topic> queryTopicBySubitemId(int subitemId,String key, Page page);
	/**
	 * ��ѯ����Ŀ�µ���������
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
