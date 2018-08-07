package com.nercel.enroll.dao;

import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import com.nercel.enroll.dao.impl.UserPhotoInfoDao;
import com.nercel.enroll.domain.model.beans.UserPhotoInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPhotoInfoDaoTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private UserPhotoInfoDao userPhotoInfoDao;

	@Test
	public void qeuryUserByCardOrName() throws InterruptedException {
		UserPhotoInfo userPhotoInfo = userPhotoInfoDao.queryUserPhotoInfoById(51);
		List<UserPhotoInfo> userPhotoInfos = userPhotoInfoDao.queryUserPhotoInfo(30);
		System.out.println(userPhotoInfo + "-----" + userPhotoInfos);
	}

	@Test
	public void testAdd() {
		UserPhotoInfo p = new UserPhotoInfo();
		p.setBase64("adfadasdsadadadadassdadadada");
		userPhotoInfoDao.save(p);
	}

}
