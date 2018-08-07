package com.nercel.enroll.core.service.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nercel.enroll.common.entity.DateFormatException;
import com.nercel.enroll.domain.common.CustomeException;

/**
 * 日期时间工具类
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public class DateUtil {
	private final static Logger LOG = LoggerFactory.getLogger(DateUtil.class);
	/**
	 * 时间解析的形式
	 */
	private final static String DATE_FORMAT = "yyyymmdd";
	/**
	 * 时间格式化参数
	 */
	private final static String DATETIME_FORMAT = "yyyy-mm-dd HH:MM:ss";
	/**
	 * 默认身份证的长度
	 */
	private final static Integer DEFAULT_LENGTH = 18;

	/**
	 * 根据身份证号判断出生日期是否在指定日期之前
	 * 
	 * @param idCard
	 *            身份证号
	 * @param targetTime
	 *            指定日期，格式为yyyyMMdd
	 * @return 如果在这个时间之前就返回为true,否则为false
	 * @throws ParseException
	 * @throws CustomeException
	 */
	public static Boolean compare(String idCard, String targetTime) throws ParseException, CustomeException {
		if (StringUtils.isBlank(idCard) || idCard.length() != DEFAULT_LENGTH) {
			throw new CustomeException("身份证号不正确");
		}

		LocalDate cardDate = LocalDate.of(IdCardUtil.getYearByIdCard(idCard), IdCardUtil.getMonthByIdCard(idCard),
				IdCardUtil.getDateByIdCard(idCard));
		LocalDate targetDate = LocalDate.of(IdCardUtil.getYearFromBirth(targetTime),
				IdCardUtil.getMonthFromBirth(targetTime), IdCardUtil.getDayFromBirth(targetTime));
		Boolean result = cardDate.isBefore(targetDate);

		LOG.debug("这里比较的两个时间为 ，身份证上的时间{}，比较的目标时间为 {},身份证上的时间是否小于目标时间的比较结果为 {}", cardDate, targetDate, result);

		return result;
	}

	/**
	 * 将yyyy-mm-dd HH:MM:ss格式的时间转换为毫秒数
	 * 
	 * @param dateTime
	 *            yyyy-mm-dd HH:MM:ss格式的时间
	 * @return
	 * @throws DateFormatException
	 * @throws ParseException
	 */
	public static synchronized Date convertDateTime(String dateTime) throws DateFormatException, ParseException {
		if (StringUtils.isBlank(dateTime)) {
			return null;
		}
		return FastDateFormat.getInstance(DATETIME_FORMAT).parse(dateTime);
	}

	/**
	 * 将毫秒数转换成yyyy-mm-dd HH:MM:ss格式的时间
	 * 
	 * @param timeSeconds
	 * @return
	 */
	public static synchronized String convertDateTime(Long timeSeconds) {
		if (timeSeconds == null) {
			return null;
		}
		return FastDateFormat.getInstance(DATETIME_FORMAT).format(timeSeconds);
	}

	/**
	 * 日期时间格式胡
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized String convertDateTime(Date date) {
		if (date == null) {
			return null;
		}
		return FastDateFormat.getInstance(DATETIME_FORMAT).format(date);
	}
}
