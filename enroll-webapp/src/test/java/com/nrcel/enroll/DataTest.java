package com.nrcel.enroll;

import java.util.Arrays;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.model.beans.UserExtendedInfo;
import com.nercel.enroll.domain.model.beans.UserGuardianInfo;
import com.nercel.enroll.domain.model.beans.UserHouseInfo;
import com.nercel.enroll.domain.model.beans.UserPhotoInfo;
import com.nercel.enroll.domain.vo.UserVo;

public class DataTest {
	@Test
	public void testUser() {
		User user = new User("用户名", "密码", "身份证号", "手机号码", "居住地址", 1, false, 1, 1, 1L,1);
		UserExtendedInfo userExtendedInfo = new UserExtendedInfo("家庭住址", "籍贯", 1, false, 
				1, 1, 1, false, false, "幼儿园",
				"学籍号", false, false, false, 1,1, "证件号");
		UserGuardianInfo userGuardianInfo = new UserGuardianInfo("监护人姓名", 1, "监护人工作单位", "监护人户口", "监护人电话", true, 1,
				"证件号", "职业", "教育", 1);

		UserHouseInfo userHouseInfo = new UserHouseInfo("房产地址", 1, "房产编码", 1, "房屋所有人", 1);

		UserPhotoInfo userPhoneInfo = new UserPhotoInfo("照片存储路径", "照片预览路径", 1, "图片的base64");
		System.out.println(JSON.toJSONString(new UserVo(user, userExtendedInfo, Arrays.asList(userGuardianInfo),
				userHouseInfo, Arrays.asList(userPhoneInfo))));
	}
}
