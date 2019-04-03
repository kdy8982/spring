package com.sample.configcontext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppContext.class)
public class AppContextTest {
	EmbeddedDatabase db;
	
	@Before
	public void setup() {
		db = new EmbeddedDatabaseBuilder()
				.setName("embeddedDatabase")
				.addScript("classpath:/script/member_table.sql")
				.addScript("classpath:/script/post_table.sql")
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
	}

	
	@Test
	public void  dbTest() {
	}

}
