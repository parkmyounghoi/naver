package com.mh.naver;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mh.naver.aspect.MyAspect;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class MyConf implements WebMvcConfigurer{

//	@Bean(initMethod = "doA")
//	public NaverLoginBO naverLoginBO() {
//		return new NaverLoginBO();
//	}
	
//	@Bean
//	public MyAspect MyAspect() {
//		return new MyAspect();
//	}
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://192.168.0.200/spring5fs?characterEncoding=utf8&serverTimezone=UTC&useUnicode=true");
		ds.setUsername("root");
		ds.setPassword("1234");
//		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());
		return tm;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
	
}












