package com.sample.configcontext;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ibatis.sqlmap.client.SqlMapClient;

@Configuration
// @ComponentScan(basePackages="com", excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Controller.class),useDefaultFilters=true)
@ComponentScan
@ImportResource("classpath:applicationContext.xml")
@Import(value = { SqlServiceContext.class })
@EnableTransactionManagement //  <tx:annotation-driven />
public class AppContext {
	
	
}
