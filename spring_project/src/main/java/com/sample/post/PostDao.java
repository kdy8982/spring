package com.sample.post;

import java.util.List;

import com.sample.domain.Post;

public interface PostDao {

	List<Post> list();

	Post get(int postId);

	int getCount();

	void add(Post post);
}
