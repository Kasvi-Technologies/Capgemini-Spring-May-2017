package com.samples.jdbcdaosupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samples.domain.Forum;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbcbeans.xml");
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumJdbcDAOSupport");
		Forum springForum = new Forum(500,"Spring Forum", "Discuss everything related to Spring");
		forumDAO.insertForum(springForum);		
		System.out.println(forumDAO.selectForum(500));
		
	}
	
}
