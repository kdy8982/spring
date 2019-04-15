package com.sample.post;

import java.util.List;

import com.sample.domain.Post;

public interface PostService {

	List<Post> list(int curPage);

	Post get(int postId);

	void add(Post post);

	List pageIndex(int curPage);

	void delete(Post post);

}
