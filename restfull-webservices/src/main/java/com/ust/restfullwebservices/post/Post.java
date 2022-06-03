package com.ust.restfullwebservices.post;

import java.util.Date;

public class Post {

	private int post_id;
	
	private Date post_time;
	
	private String post_head;
	
	private String post_body;

	public Post(int post_id, Date post_time, String post_head, String post_body) {
		super();
		this.post_id = post_id;
		this.post_time = post_time;
		this.post_head = post_head;
		this.post_body = post_body;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}

	public String getPost_head() {
		return post_head;
	}

	public void setPost_head(String post_head) {
		this.post_head = post_head;
	}

	public String getPost_body() {
		return post_body;
	}

	public void setPost_body(String post_body) {
		this.post_body = post_body;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_time=" + post_time + ", post_head=" + post_head + ", post_body="
				+ post_body + "]";
	}
	
	
	
}
