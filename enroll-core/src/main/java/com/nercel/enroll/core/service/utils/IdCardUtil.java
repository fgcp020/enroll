package com.nercel.enroll.core.service.utils;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import com.nercel.enroll.domain.common.CustomeException;

/**
 * 身份证号工具类
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public class IdCardUtil {
	/** 中国公民身份证号码最小长度。 */
	public final int CHINA_ID_MIN_LENGTH = 15;

	/** 中国公民身份证号码最大长度。 */
	public final int CHINA_ID_MAX_LENGTH = 18;
	/**
	 * 生日的长度
	 */
	private final static Integer LENGTH_OF_BIRTH = 8;

	/**
	 * 根据身份编号获取年龄
	 *
	 * @param idCard
	 *            身份编号
	 * @return 年龄
	 * @throws CustomeException
	 */
	public static int getAgeByIdCard(String idCard) throws CustomeException {
		int iAge = 0;
		try {
			Calendar cal = Calendar.getInstance();
			String year = idCard.substring(6, 10);
			int iCurrYear = cal.get(Calendar.YEAR);
			iAge = iCurrYear - Integer.valueOf(year);
		} catch (Exception e) {
			throw new CustomeException(e.getMessage());
		}
		return iAge;
	}

	/**
	 * 从yyyyMMdd格式的日期中获取到年份
	 * 
	 * @param birth
	 *            yyyyMMdd格式的日期
	 * @return 年份
	 */
	public static int getYearFromBirth(String birth) {
		if (StringUtils.isNotBlank(birth) && birth.length() == LENGTH_OF_BIRTH) {
			return Integer.valueOf(StringUtils.substring(birth, 0, 4));
		}
		return 0;
	}

	/**
	 * 从yyyyMMdd格式的日期中获取到月份
	 * 
	 * @param birth
	 *            yyyyMMdd格式的日期
	 * @return 月份
	 */
	public static int getMonthFromBirth(String birth) {
		if (StringUtils.isNotBlank(birth) && birth.length() == LENGTH_OF_BIRTH) {
			return Integer.valueOf(StringUtils.substring(birth, 4, 6));
		}
		return 0;
	}

	/**
	 * 从yyyyMMdd格式的日期中获取到天数
	 * 
	 * @param birth
	 *            yyyyMMdd格式的日期
	 * @return 天数
	 */
	public static int getDayFromBirth(String birth) {
		if (StringUtils.isNotBlank(birth) && birth.length() == LENGTH_OF_BIRTH) {
			return Integer.valueOf(StringUtils.substring(birth, 6, 8));
		}
		return 0;
	}

	/**
	 * 根据身份编号获取生日
	 *
	 * @param idCard
	 *            身份编号
	 * @return 生日(yyyyMMdd)
	 */
	public static String getBirthByIdCard(String idCard) {
		return idCard.substring(6, 14);
	}

	/**
	 * 根据身份编号获取生日年
	 *
	 * @param idCard
	 *            身份编号
	 * @return 生日(yyyy)
	 */
	public static Short getYearByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(6, 10));
	}

	/**
	 * 根据身份编号获取生日月
	 *
	 * @param idCard
	 *            身份编号
	 * @return 生日(MM)
	 */
	public static Short getMonthByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(10, 12));
	}

	/**
	 * 根据身份编号获取生日天
	 *
	 * @param idCard
	 *            身份编号
	 * @return 生日(dd)
	 */
	public static Short getDateByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(12, 14));
	}

	/**
	 * 根据身份编号获取性别
	 *
	 * @param idCard
	 *            身份编号
	 * @return 性别(M-男，F-女，N-未知)
	 */
	public static String getGenderByIdCard(String idCard) {
		String sGender = "未知";

		String sCardNum = idCard.substring(16, 17);
		if (Integer.parseInt(sCardNum) % 2 != 0) {
			sGender = "1";// 男
		} else {
			sGender = "0";// 女
		}
		return sGender;
	}

}
