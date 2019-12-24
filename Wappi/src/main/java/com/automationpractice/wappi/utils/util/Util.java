package com.automationpractice.wappi.utils.util;

import static java.lang.Thread.sleep;

import org.apache.log4j.Logger;

public class Util {

	private Util() {
	}

	private static final Logger LOGGER = Logger.getLogger(Util.class);

	public static boolean isNullOrEmpty(String text) {
		return (text == null || "".equals(text.trim()));
	}

	public static void waitForSomeTime(int seconds) {
		try {
			sleep(seconds * 1_000L);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
		}
	}
}
