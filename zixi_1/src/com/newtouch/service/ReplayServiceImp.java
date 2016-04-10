package com.newtouch.service;

import java.util.List;

import com.newtouch.dao.ReplayDao;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.Replay;
import com.newtouch.entity.User;
import com.newtouch.util.Page;
import com.newtouch.util.PageUtil;
import com.newtouch.util.Result;

public class ReplayServiceImp implements ReplayService {

	private ReplayDao replayDao;
	private UserDao userDao;
	
	


	public ReplayDao getReplayDao() {
		return replayDao;
	}

	public void setReplayDao(ReplayDao replayDao) {
		this.replayDao = replayDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result findReplayByTopicId(int topicId, Page page) {
		// TODO Auto-generated method stub
		System.out.println("count::"+replayDao.queryReplayCount(topicId, 1));
		page = PageUtil.createPage(page.getEveryPage(), replayDao.queryReplayCount(topicId, 1),page.getCurrentPage());
		List<Replay> replay = replayDao.queryReplayByTopicId(topicId, page);
		System.out.println("REP,LAY1:"+replay.size());
		Result result = new Result();
		result.setPage(page);
		result.setList(replay);
		return result;
	}

	@Override
	public boolean addReplay(Replay replay) {
		// TODO Auto-generated method stub
		User user = userDao.byUsername(replay.getManageruser().getUsername());
		
		   if(user!=null){
			    user.setIntegral(user.getIntegral()+1);//用户积分加5
			    replay.setManageruser(user);
			    replayDao.saveReplay(replay);
			    return true;
		   }
		return false;
	}

	@Override
	public Replay findReplayById(int replayId) {
		// TODO Auto-generated method stub
		return replayDao.queryReplayById(replayId, 1);
	}

}
