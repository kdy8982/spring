package com.sample.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.Post;
import com.sample.util.PagingCalc;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao postDao;
	
	@Override
	public List<Post> list(int curPage) {
		return postDao.list(curPage);
	}

	@Override
	public Post get(int postId) {
		return postDao.get(postId);
	}

	@Override
	public void add(Post post) {
		postDao.add(post);
	}

	@Override
	public List pageIndex(int curPage) {
		PagingCalc pc = new PagingCalc(postDao.getCount(), 10, 10, curPage);
		return pc.getIndexArr();
	}

	@Override
	public void delete(Post post) {
		
		postDao.delete(post);
		
	}

}
