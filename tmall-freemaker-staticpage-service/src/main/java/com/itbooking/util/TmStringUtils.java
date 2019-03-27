package com.itbooking.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class TmStringUtils {
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return  null == str || str.length() == 0 || "".equals(str) || str.matches("\\s*");
	}
	
	public static boolean isNotEmtpy(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 判断字符串是否都是数字组成
	 * 
	 * @param numString
	 * @return
	 */
	public static boolean isNumber(String numString) {
		return StringUtils.isNumeric(numString);
	}
	
	/**
	 * @作用:判断是否为数字
	 */
	public static boolean isNumeric(String str) {
		Matcher isNum = Pattern.compile("(-|\\+)?[0-9]+(.[0-9]+\\+)?").matcher(str);
		return isNum.matches();
	}
	
	/**
	 * 随即生产随即数，可以用来生产tocken字符串等.
	 * 
	 * @param length 生成长度
	 * @return 随即数字符串.
	 */
	public static String getRandomString(int length) {
		StringBuffer bu = new StringBuffer();
		String[] arr = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		Random random = new Random();
		while (bu.length() < length) {
			String temp = arr[random.nextInt(57)];
			if (bu.indexOf(temp) == -1) {
				bu.append(temp);
			}
		}
		return bu.toString();
	}
}
