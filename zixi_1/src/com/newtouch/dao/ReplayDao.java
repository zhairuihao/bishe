package com.newtouch.dao;

import java.util.List;

import com.newtouch.entity.Replay;

import com.newtouch.util.Page;

public interface ReplayDao {

	public void saveReplay(Replay replay);
	public List<Replay> queryReplayByTopicId(int TopicId,Page page);
	public int queryReplayCount(int TopicId, int d_delete) ;
	public Replay queryReplayById(int replayid,int d_delete);
}
