package com.nercel.enroll.dao;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import com.nercel.enroll.dao.impl.NationDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NationDaoTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private NationDao nationDao;

	@Test
	public void sendSimpleMessage() throws InterruptedException {
		System.out.println(nationDao.queryNationById(1)); 
	}
}
