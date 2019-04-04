package com.sample.post;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.configcontext.AppContext;
import com.sample.domain.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppContext.class)
public class PostDaoIbatisTest {

	@Autowired
	PostDao postDao;
	
	
	@Test
	public void TestDoaInjection() {
		assertThat(postDao, is(notNullValue()));
	}
	
	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Post post1 = postDao.get(1);
		System.out.println(post1.getContent());

	}

}
