package com.ust.restfullwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ust.restfullwebservices.post.Post;
import com.ust.restfullwebservices.post.PostsNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}

		return user;
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPostsOfAUser(@PathVariable int id) {
		List<Post> posts = service.FindAllPosts(id);

		if (posts == null) {
			throw new PostsNotFoundException("id-" + id);
		}

		return posts;
	}

	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retriveOnePostOfAUser(@PathVariable int id, @PathVariable int post_id) {
		Post post = service.FindOnePost(id, post_id);

		if (post == null) {
			throw new PostsNotFoundException("id-" + id);
		}

		return post;
	}

	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity createPost(@PathVariable int id, @RequestBody Post post) {
		Post savedPost = service.savePost(id, post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}")
				.buildAndExpand(savedPost.getPost_id()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}

	}

}
