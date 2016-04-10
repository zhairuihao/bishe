package com.newtouch.action;

import java.util.List;
import java.util.Map;

import com.newtouch.entity.Replay;
import com.newtouch.entity.Topic;
import com.newtouch.service.ReplayService;
import com.newtouch.service.SubItemService;
import com.newtouch.service.TopicService;
import com.newtouch.util.Page;
import com.newtouch.util.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindTopicAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int topicId;
	private Topic topic;
	private int subitemId;
	private String subitemName;
	private List<Replay>replay;
	private int currentPage;
	private Page page;
	private TopicService topicService;
	private SubItemService subitemService;
    private ReplayService replayService;
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getSubitemId() {
		return subitemId;
	}
	public void setSubitemId(int subitemId) {
		this.subitemId = subitemId;
	}
	public String getSubitemName() {
		return subitemName;
	}
	public void setSubitemName(String subitemName) {
		this.subitemName = subitemName;
	}
	public List<Replay> getReplay() {
		return replay;
	}
	public void setReplay(List<Replay> replay) {
		this.replay = replay;
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
		topic = topicService.findTopicById(topicId);	
		topic.setHasread(topic.getHasread()+1);//‰Ø¿¿¡ø+1
		topicService.updateTopic(topic);
		subitemName = subitemService.findSubItemById(subitemId).getSubitemName();
		
	    Page zpage = new Page();
	    zpage.setCurrentPage(currentPage);
	    zpage.setEveryPage(10);
	    Result result =replayService.findReplayByTopicId(topicId, zpage);
		page = result.getPage();
		replay = result.getList();
		//System.out.println("REPLAY:"+replay.size());
		
		Map<String, Object> session =  ActionContext.getContext().getSession();	       		
		session.put("pagee", page);
		session.put("replay", replay);
		session.put("topic", topic);
		
		return SUCCESS;
	}	
    
    
	
	

}
