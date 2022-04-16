package com.hrm.utils;

import java.util.Random;

public class CommonUtils {
	public static String getRandomCalendarMonth() {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int index = new Random().nextInt(12);
		return months[index];
	}

	public static Integer getRandomInteger(int limit) {
		return new Random().nextInt(limit);
	}
}
