package com.sample.post;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sample.domain.Post;
import com.sample.util.PagingCalc;


@Repository
public class PostDaoIbatis implements PostDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<Post> list(int curPage) {
		return sqlMapClientTemplate.queryForList("Post.list", new PagingCalc(getCount(), 10, 10, curPage) );
	}

	@Override
	public Post get(int postId) {
		Post resultPost = (Post) sqlMapClientTemplate.queryForObject("Post.get", postId);
		if(resultPost == null) {
			return null;
		} else {
			
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
			System.out.println(df.format(resultPost.getDatetime()));
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

	@Override
	public void delete(Post post) {
		sqlMapClientTemplate.delete("Post.delete", post);
		
	}

}
