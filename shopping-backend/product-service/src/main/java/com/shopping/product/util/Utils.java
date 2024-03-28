package com.shopping.product.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
	public static java.util.Date getCurrentUtcTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		try {
			return localDateFormat.parse(simpleDateFormat.format(new Date(0)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
