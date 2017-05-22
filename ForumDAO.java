package com.samples.jdbcdaosupport;

import com.samples.domain.Forum;

public interface ForumDAO {
	public void insertForum(Forum forum);
	public Forum selectForum(int forumId);	
}
