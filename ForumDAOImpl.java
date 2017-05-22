package com.samples.jdbcdaosupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.samples.domain.Forum;

public class ForumDAOImpl extends JdbcDaoSupport implements ForumDAO{

	public void insertForum(Forum forum) {
		/**
		 * Specify the statement
		 */
		String query = "INSERT INTO FORUMS (FORUM_ID, FORUM_NAME, FORUM_DESC) VALUES (?,?,?)";
		/**
		 * Specify the values 
		 */
		this.getJdbcTemplate().update(query, new Object[] { Integer.valueOf(forum.getForumId()),
				forum.getForumName(), forum.getForumDesc() });
	}
	
	public Forum selectForum(int forumId) {
		/**
		 * Specify the statement
		 */
		String query = "SELECT * FROM FORUMS WHERE FORUM_ID=?";
		/**
		 * Implement the RowMapper callback interface
		 */
		return (Forum) this.getJdbcTemplate().queryForObject(query, new Object[] { Integer.valueOf(forumId) }, 
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new Forum(resultSet.getInt("FORUM_ID"), resultSet.getString("FORUM_NAME"), 
								resultSet.getString("FORUM_DESC"));
					}
				});
	}

}
