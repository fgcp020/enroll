package com.nercel.enroll.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nercel.enroll.dao.impl.NationDao;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac=SpringApplication.run(App.class, args);
    	NationDao dao=	ac.getBean(NationDao.class);
    	System.out.println(dao.queryNationById(1)); 
    }
}
