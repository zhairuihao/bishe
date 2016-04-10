package com.newtouch.entity;

import java.util.Date;
import java.util.Set;

public class Topic {
	
	
	
   int topicId;
   String title;
   String content;
   User user;
   Date date;
   int hasread;//查看次数
   int subitemId;//外键
   int d_delete;//删除标记
   Set<Replay> replay;
   
   
   
public Topic() {
	super();
}
public Topic(int topicId, String title,User user, String content, Date date,
		int hasread, int subitemId, int d_delete) {
	super();
	this.topicId = topicId;
	this.title = title;
	this.user = user;
	this.content = content;	
	this.date = date;
	this.hasread = hasread;
	this.subitemId = subitemId;
	this.d_delete = d_delete;
}
public int getTopicId() {
	return topicId;
}
public void setTopicId(int topicId) {
	this.topicId = topicId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getHasread() {
	return hasread;
}
public void setHasread(int hasread) {
	this.hasread = hasread;
}
public int getSubitemId() {
	return subitemId;
}
public void setSubitemId(int subitemId) {
	this.subitemId = subitemId;
}
public int getD_delete() {
	return d_delete;
}
public void setD_delete(int d_delete) {
	this.d_delete = d_delete;
}
public Set<Replay> getReplay() {
	return replay;
}
public void setReplay(Set<Replay> replay) {
	this.replay = replay;
}
   
   
   

}
