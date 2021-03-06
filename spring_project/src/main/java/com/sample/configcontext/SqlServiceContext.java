package com.sample.configcontext;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import com.ibatis.sqlmap.client.SqlMapClient;

@Configuration
@ComponentScan(basePackages="com", excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Controller.class))
public class SqlServiceContext {
	
	@Bean
	public DataSource embeddedDatabase() {
		return new EmbeddedDatabaseBuilder()
				.setName("embeddedDatabase")
				.addScript("classpath:/script/post_table.sql")
				.addScript("classpath:/script/member_table.sql")
				.setType(EmbeddedDatabaseType.HSQL)
				.build();
	}
	
	@Bean
	public SimpleDriverDataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3307/spring");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean 
	public SqlMapClientFactoryBean sqlMapClient() {
		SqlMapClientFactoryBean sqlMapClientFactoryBean = new SqlMapClientFactoryBean();
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		
		sqlMapClientFactoryBean.setDataSource(dataSource());
		sqlMapClientFactoryBean.setConfigLocation(pmrpr.getResource("classpath:/SqlMapConfig.xml"));
		
		return sqlMapClientFactoryBean;
	}
	
	@Bean
	public SqlMapClientTemplate sqlMapClientTemplate(SqlMapClient sqlMapClient) {
		SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate();
		sqlMapClientTemplate.setSqlMapClient(sqlMapClient);
		return sqlMapClientTemplate;
	}
}
