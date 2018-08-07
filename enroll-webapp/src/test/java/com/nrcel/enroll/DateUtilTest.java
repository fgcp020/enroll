/**
 * 
 */
package com.nrcel.enroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author yishui
 * @date 2018年6月20日
 * @version 0.0.1
 */
public class DateUtilTest {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		/*System.out.println("原始的时间格式为  2018-06-27 12:12:12");
		Date date = DateUtils.parseDate("2018-06-27 12:12:12", "yyyy-mm-dd HH:MM:ss");
		System.out.println("转换后的时间为 " + date);
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").format(date));
		Date date2 = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse("2018-06-27 12:12:12");
		System.out.println("转换后的时间为 " + date2);*/
		System.out.println(new Date());
		System.out.println("转换后的时间为 ------------------ " + new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(new Date()));
	}

}
