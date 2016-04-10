package com.newtouch.action;

import java.util.Date;
import java.util.Map;

import com.newtouch.entity.Replay;
import com.newtouch.entity.Topic;
import com.newtouch.entity.User;
import com.newtouch.service.ReplayService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReplayAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String content;
	private ReplayService replayService;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ReplayService getReplayService() {
		return replayService;
	}
	public void setReplayService(ReplayService replayService) {
		this.replayService = replayService;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, User> session = (Map<String, User>) ActionContext.getContext().getSession();
		Map<String, Topic> se = (Map<String, Topic>) ActionContext.getContext().getSession();
		Replay replay =new Replay();
		replay.setTopicId(se.get("topic").getTopicId());
		replay.setContent(content);
		replay.setDate(new Date());
		replay.setD_delete(1);
		
		User user = new User();
	;
		user.setUsername(session.get("user_admin").getUsername());
		replay.setManageruser(user);
		
		replayService.addReplay(replay);
		
		return SUCCESS;
	}
	
	
	
	

}
