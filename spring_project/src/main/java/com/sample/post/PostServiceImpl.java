package com.sample.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.Post;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;
	
	@Override
	public List<Post> list() {
		return postDao.list();
	}

	@Override
	public Post get(int postId) {
		return postDao.get(postId);
	}

}
