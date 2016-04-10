package com.newtouch.entity;

import java.util.Date;

public class Replay {

	
	
	int Id;
	int topicId;
	String content;
	Date date;
	User manageruser;
    int d_delete;//É¾³ý±ê¼Ç
    
    
    
     
    
    
	public Replay() {
		super();
	}
	public Replay(int id, int topicId, String content, Date date,
			User manageruser, int d_delete) {
		super();
		Id = id;
		this.topicId = topicId;
		this.content = content;
		this.date = date;
		this.manageruser = manageruser;
		this.d_delete = d_delete;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public User getManageruser() {
		return manageruser;
	}
	public void setManageruser(User manageruser) {
		this.manageruser = manageruser;
	}
	public int getD_delete() {
		return d_delete;
	}
	public void setD_delete(int d_delete) {
		this.d_delete = d_delete;
	}
    
    
}
