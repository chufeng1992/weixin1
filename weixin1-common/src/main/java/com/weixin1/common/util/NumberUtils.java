package com.weixin1.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

public final class NumberUtils {
	/**
	 * LOGGER
	 */
	private static final org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(NumberUtils.class);

	/**
	 * Pattern
	 */
	private static final Pattern PATTERN = Pattern.compile("^\\d+(\\.\\d+)?$");

	/**
	 * 获得数字的值
	 * 
	 * @param value
	 *            值的字符串
	 * @return 数字的值
	 */
	public static Object getNumberValue(String value) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		Matcher matcher = PATTERN.matcher(value);
		if (!matcher.find()) {
			return null;
		}

		if (value.indexOf(".") > 0) {
			return NumberUtils.getDoubleValue(value);
		}

		return NumberUtils.getIntegerValue(value);
	}

	/**
	 * 获得双精度浮点型数据值
	 * 
	 * @param value
	 *            值的字符串
	 * @return 双精度浮点型数据值
	 */
	public static Double getDoubleValue(String value) {
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
			LOGGER.error("can not parse value ['" + value + "'] to double!");
		}
		return null;
	}

	/**
	 * 获得整形数值
	 * 
	 * @param value
	 *            值的字符串
	 * @return 整形数值
	 */
	public static Integer getIntegerValue(String value) {
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			LOGGER.error("can not parse value ['" + value + "'] to int value!");
		}
		return null;
	}
}