package com.newtouch.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.newtouch.dao.ReplayDao;
import com.newtouch.entity.Replay;
import com.newtouch.util.Page;

public class ReplayDaoImp extends HibernateDaoSupport implements ReplayDao {

	@Override
	public void saveReplay(Replay replay) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(replay);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Replay> queryReplayByTopicId(int TopicId, Page page) {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		Query query = session.createQuery("from Replay where d_delete=1 and TopicId = :id");
		query.setInteger("id", TopicId);
		//设置分页信息
	    System.out.println("asdasd"+query.list().size());
		query.setFirstResult(page.getBeginIndex());//起始点
		query.setMaxResults(page.getEveryPage());//每页记录数
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryReplayCount(int TopicId, int d_delete) {
		// TODO Auto-generated method stub
         List<Replay> replays = getHibernateTemplate().find("from Replay where d_delete=1 and TopicId=?",TopicId);
		System.out.println("countDao::"+replays.size());
		return replays.size();
	}

	@Override
	public Replay queryReplayById(int replayid, int d_delete) {
		// TODO Auto-generated method stub
		Replay replays = (Replay) getHibernateTemplate().find("from Replay where d_delete=1 and replayid= ?",replayid).get(0);
		return replays;
	}

}
