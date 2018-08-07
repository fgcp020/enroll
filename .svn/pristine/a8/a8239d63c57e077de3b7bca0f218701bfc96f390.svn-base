package com.nercel.enroll.dao;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import com.nercel.enroll.dao.impl.UserDao;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private UserDao userDao;

	@Test
	public void qeuryUserByCardOrName() throws InterruptedException {
		System.out.println(userDao.qeuryUserByCardOrName("aaa1", "123456"));
		System.out.println(userDao.qeuryUserByCardOrName("421181199009228437", "123456"));
	}

}
