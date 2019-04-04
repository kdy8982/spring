package com.sample.post;

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
			System.out.println("1111111111111111111");
			return null;
		}else {
			System.out.println("2222222222222222222");
			System.out.println(resultPost.getContent());
			return resultPost;
		}
		
	}

	@Override
	public int getCount() {
		return (int) sqlMapClientTemplate.queryForObject("Post.getCount");
	}
	
	

}
