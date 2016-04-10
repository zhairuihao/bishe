package com.newtouch.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newtouch.dao.TopicDao;
import com.newtouch.entity.Topic;
import com.newtouch.util.Page;

public class TopicDaoImp extends HibernateDaoSupport implements TopicDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> queryTopicBySubitemId(int subitemId, Page page) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session
				.createQuery("from Topic where d_delete=1 and subitemId = :id");
		query.setInteger("id", subitemId);
		// 设置分页信息
		query.setFirstResult(page.getBeginIndex());// 起始点
		query.setMaxResults(page.getEveryPage());// 每页记录数

		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> queryTopicBySubitemId(int subitemId, String key,
			Page page) {
		Session session = getSession();
		Query query = session
				.createQuery("from Topic where d_delete=1 and subitemId = :id and title like '%"+key+"%'");
		query.setInteger("id", subitemId);
		// 设置分页信息
		System.out.println("from Topic where d_delete=1 and subitemId = :id and title like '%"+key+"%'");
		query.setFirstResult(page.getBeginIndex());// 起始点
		query.setMaxResults(page.getEveryPage());// 每页记录数
        System.out.println(query.list());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryTopicCount(int subitemId, int d_delete) {
		// TODO Auto-generated method stub
		List<Topic> topics = getHibernateTemplate().find(
				"from Topic where d_delete=1 and subitemId=?", subitemId);

		return topics.size();
	}

	@Override
	public int queryTopicCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveTopic(Topic topic) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(topic);
	}

	@Override
	public Topic queryTopicById(int topicId, int d_delete) {
		// TODO Auto-generated method stub
		Topic topic = (Topic) getHibernateTemplate().find(
				"from Topic where d_delete=1 and topicId= ?", topicId).get(0);
		return topic;
	}

	@Override
	public void updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		Topic top = new Topic();
		top = (Topic) getHibernateTemplate().get(Topic.class,
				topic.getTopicId());
		top.setHasread(topic.getHasread());
		getHibernateTemplate().save(top);

	}

}
