package com.sample.applicationcontext;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ibatis.sqlmap.client.SqlMapClient;

@Configuration
@ImportResource("classpath:applicationContext.xml")
@EnableTransactionManagement
public class TestApplicationContext {
	
	@Bean
	public DataSource embeddedDatabase() {
		return new EmbeddedDatabaseBuilder()
				.setName("embeddedDatabase")
				.addScript("classpath:/script/member_table.sql")
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(embeddedDatabase());
		return tm;
		
	}

	@Bean
	public SqlMapClientTemplate sqlMapClientTemplate() {
		SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate();
		sqlMapClientTemplate.setSqlMapClient((SqlMapClient) sqlMapClient());
		return sqlMapClientTemplate;
	}
	
	
	@Bean 
	public SqlMapClientFactoryBean sqlMapClient() {
		SqlMapClientFactoryBean sqlMapClientFactoryBean = new SqlMapClientFactoryBean();
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		
		sqlMapClientFactoryBean.setDataSource(embeddedDatabase());
		sqlMapClientFactoryBean.setConfigLocation(pmrpr.getResource("classpath:/SqlMapConfig.xml"));
		return ;
	}
}
