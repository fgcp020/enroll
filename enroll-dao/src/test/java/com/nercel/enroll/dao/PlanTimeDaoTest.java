package com.nercel.enroll.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import com.nercel.enroll.dao.impl.PlanTimeDao;
import com.nercel.enroll.domain.model.beans.PlanTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanTimeDaoTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private PlanTimeDao planTimeDao;

	@Test
	public void tesPlanTimeDao() throws ParseException {
		PlanTime planTime = new PlanTime(time("2018-06-23 00:00:00"), time("2018-07-04 23:59:59"),
				time("2018-07-05 00:00:00"), time("2018-07-17 23:59:59"),

				time("2018-07-18 00:00:00"), time("2018-07-20 23:59:59"), time("2018-07-21 00:00:00"),
				time("2018-07-25 23:59:59"),

				time("2018-07-26 00:00:00"), time("2018-08-17 23:59:59"), time("2018-08-18 00:00:00"),
				time("2018-08-28 23:59:59"),

				time("2018-08-29 00:00:00"), time("2018-08-30 23:59:59"), time("2018-08-31 00:00:00"),
				time("2018-08-31 23:59:59"),

				time("2018-09-01 00:00:00"), time("2018-09-20 23:59:59"));
		planTimeDao.savePlanTime(planTime);
	}

	static Date time(String date) throws ParseException {

		return DateUtils.parseDate(date, "yyyy-mm-dd HH:MM:ss");
	}

	public static void main(String[] args) throws ParseException {
		// Date date=new SimpleDateFormat("yyyy-MM-dd
		// HH:MM:ss",Locale.CHINA).parse("2018-06-23 00:00:00");

		Date date = new Date();
		date = DateUtils.setMonths(date, 6);
		date = DateUtils.setDays(date, 4);
		date = DateUtils.setHours(date, 23);
		date = DateUtils.setMinutes(date, 0);

		System.out
				.println(date.getTime() + "--------------" + new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(date));

		System.out.println(new Date(System.currentTimeMillis()));
	}
}
