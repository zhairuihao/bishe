package com.newtouch.service;

import com.newtouch.entity.Replay;
import com.newtouch.util.Page;
import com.newtouch.util.Result;

public interface ReplayService {
	
	public Result findReplayByTopicId(int topicId, Page page);
	public boolean addReplay(Replay replay);
	public Replay findReplayById(int replayId);

}
