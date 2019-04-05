package com.sample.post;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sample.domain.Post;


@Repository
public class PostDaoIbatis implements PostDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<Post> list() {
		return sqlMapClientTemplate.queryForList("Post.list");
	}

	@Override
	public Post get(int postId) {
		Post resultPost = (Post) sqlMapClientTemplate.queryForObject("Post.get", postId);
		if(resultPost == null) {
			return null;
		}else {
			return resultPost;
		}
		
	}

	@Override
	public int getCount() {
		return (int) sqlMapClientTemplate.queryForObject("Post.getCount");
	}

	@Override
	public void add(Post post) {
		post.setDatetime(new Date());
		sqlMapClientTemplate.insert("Post.add", post);
		
	}
	
	

}
