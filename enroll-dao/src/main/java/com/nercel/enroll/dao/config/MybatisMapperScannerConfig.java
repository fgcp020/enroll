package com.nercel.enroll.dao.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * mycat扫描配置
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@Configuration
public class MybatisMapperScannerConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer scanner = new MapperScannerConfigurer();
		scanner.setSqlSessionFactoryBeanName("sqlSessionFactory"); // set
																	// 手动配置的sqlSessionFactory
		scanner.setBasePackage("com.nercel.enroll.dao.mapperInterface");
		return scanner;
	}
}