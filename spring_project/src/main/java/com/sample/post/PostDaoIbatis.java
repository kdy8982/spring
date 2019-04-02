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

}
