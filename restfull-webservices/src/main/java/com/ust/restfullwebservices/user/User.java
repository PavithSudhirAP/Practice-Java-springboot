package com.ust.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ust.restfullwebservices.post.Post;

public class User {
	
	private int id;
	private String name;
	private Date birthDate;
	private List<Post> posts = new ArrayList<>();
	
	public User() {}
	
	public User(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public User(int id, String name, Date birthDate, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	
	
	
}
