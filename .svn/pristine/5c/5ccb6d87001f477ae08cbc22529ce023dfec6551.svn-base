package com.nercel.enroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目启动入口
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class App extends SpringBootServletInitializer {
	private final static Logger LOG = LoggerFactory.getLogger(App.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(App.class);
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(App.class, args);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		LOG.debug("=================================== 启动成功");
	}

}