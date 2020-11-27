package com.maker.cms.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	public static final String PATTERN_MMMDD_HHMMSS = "MMM-dd HH:mm:SS";
	public static final String PATTERN_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:SS";
	public static final String PATTERN_DDMMYYYY_HHMMSS_NO_SLASH = "yyyyMMddHHmmSS";
	public static final String PATTERN_DDMMYYYY_HHMM = "dd/MM/yyyy HH:mm";
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String PATTERN_DD_MM = "dd/MM";
	public static final String PATTERN_MM_DD = "MMdd";
	public static final String PATTERN_D_M_Y = "d-M-y";
	public static final String PATTERN_YYYY_MM_DD = "yyyy_MM_dd";
	public static final long DAY_1 = 24 * 60 * 60 * 1000;

	public static String toString(Calendar calendar, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(calendar.getTime());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static long toMiliseconds(String date, String pattern) {
		Timestamp t = toTimestamp(date, pattern);
		if (t == null) {
			return 0;
		}
		return t.getTime();
	}

	public static String toString(Date calendar, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(calendar.getTime());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static String toString(Long miliseconds, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(miliseconds);
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static String toString(Date calendar) {
		String pattern = PATTERN_YYYYMMDD_HHMMSS;
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(calendar.getTime());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static String toString(Long time) {
		String pattern = PATTERN_YYYYMMDD_HHMMSS;
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(new Timestamp(time));
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static String toString(String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);

			String reportDate = df.format(System.currentTimeMillis());
			return reportDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static Timestamp toTimestamp(String datetime, String pattern) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			date = (Date) formatter.parse(datetime);
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}

		if (date == null) {
			return null;
		}

		return new Timestamp(date.getTime());
	}


	public static Date toDateTime(String datetime, String pattern) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			date = (Date) formatter.parse(datetime);
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}

		if (date == null) {
			return null;
		}

		return date;
	}


	public static Timestamp getMillisFirstDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return new Timestamp(c.getTimeInMillis());
	}

	public static Timestamp getMillisEndDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 24);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return new Timestamp(c.getTimeInMillis());
	}

	public static String convert(String src, String patternFrom, String patternTo) {
		try {
			DateFormat formatter = new SimpleDateFormat(patternFrom);
			formatter.setLenient(false);
			Date date = formatter.parse(src);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return toString(c, patternTo);
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}
		return "";
	}

	public static Calendar toCalendar(String src, String pattern) {
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			Date date = formatter.parse(src);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return c;
		} catch (ParseException e) {
			// System.out.println("Exception :" + e);
		}
		return Calendar.getInstance();
	}

	public static int toDateInt() {
		try {
			DateFormat df = new SimpleDateFormat(PATTERN_YYYYMMDD);

			String reportDate = df.format(System.currentTimeMillis());
			return MathUtil.parseInt(reportDate, 0);
		} catch (Exception e) {
			return 0;
		}
	}

	public static int toDateInt(long milis) {
		try {
			DateFormat df = new SimpleDateFormat(PATTERN_YYYYMMDD);

			String reportDate = df.format(milis);
			return MathUtil.parseInt(reportDate, 0);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static Timestamp getCurrentTime() {
		Date date = new Date();
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		long time = date.getTime() - timeZone.getRawOffset();
		return new Timestamp(time);
	}

	public static void main(String[] args) {
//		System.out.println(getMillisFirstDay());
//		System.out.println(getMillisEndDay());
//		System.out.println(toString(1545113950000L, PATTERN_MMMDD_HHMMSS));
	}
}
