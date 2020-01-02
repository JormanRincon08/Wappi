package com.automationpractice.wappi.utils.util;

import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Util {

	private Util() {
	}

	private static final Logger LOGGER = Logger.getLogger(Util.class);

	public static boolean isNullOrEmpty(String text) {
		return (text == null || "".equals(text.trim()));
	}

	public static void waitForSomeTimeUtil(int seconds) {
		try {
			sleep(seconds * 1_000L);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
		}
	}

	public static Timestamp getDateTimestamp(String strDate) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
			Date date = formatter.parse(strDate);
			return new Timestamp(date.getTime());

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
}
