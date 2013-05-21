package com.saltlux.common.util;


public class StringUtils extends org.apache.commons.lang.StringUtils {

	/**
	 * Check string is null. Return true if the string is null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return (str == null);
	}
	
	/**
	 * Check string is not null. Return true if the string is not null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
}
