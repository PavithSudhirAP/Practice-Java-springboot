package com.ust.restfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.restfullwebservices.post.Post;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();

	private static List<Post> posts = new ArrayList<>();

	private static int userCount;

	static {
		users.add(new User(1, "Johnn", new Date()));
		users.add(new User(2, "Arjun", new Date()));
		users.add(new User(3, "David", new Date()));

		posts.add(new Post(1, new Date(), "Anirudhs New Post!!!", "This is Anirudh!!"));
		posts.add(new Post(2, new Date(), "Anirudhs Second Post!!!", "How are you alllll..."));
		users.add(new User(4, "Anirudh", new Date(), posts));
		
		userCount = 4;
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<Post> FindAllPosts(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user.getPosts();
			}
		}
		return null;
	}
	
	public Post FindOnePost(int id, int post_id) {
		for (User user : users) {
			if (user.getId() == id) {
				for(Post post:user.getPosts()) {
					if(post.getPost_id() == post_id) {
						return post;
					}
				}
			}
		}
		return null;
	}
	
	public Post savePost(int id, Post post) {
		for (User user : users) {
			if (user.getId() == id) {
				List<Post> posts = user.getPosts();
				if(posts == null) {
					post.setPost_id(1);
				} else {
					post.setPost_id(posts.size() + 1);
				}
				post.setPost_time(new Date());
				posts.add(post);
				user.setPosts(posts);
				return post;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
}
