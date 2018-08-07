package com.nrcel.enroll;

import org.apache.commons.lang3.StringUtils;

public class MainTest {

	public static void main(String[] args) {
		String str="2018-06-27 12:12:12";
		
		System.out.println(StringUtils.substring(str, 0, 4)); 
		System.out.println(StringUtils.substring(str, 5, 7)); 
		System.out.println(StringUtils.substring(str, 8, 10));
	}

}
