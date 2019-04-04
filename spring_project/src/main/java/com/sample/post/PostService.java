package com.sample.post;

import java.util.List;

import com.sample.domain.Post;

public interface PostService {

	List<Post> list();

	Post get(int postId);

}
