package com.maker.cms.utils;

public class MathUtil {
	public static Integer parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return null;
		}
	}
	public static int parseInt(String s, int val) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return val;
		}
	}
	public static Long parseLong(String s) {
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return null;
		}
	}
	public static long parseLong(String s, long val) {
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return val;
		}
	}

}
