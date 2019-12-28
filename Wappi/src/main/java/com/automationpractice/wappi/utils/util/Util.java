package com.automationpractice.wappi.utils.util;

import static java.lang.Thread.sleep;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.pages.components.FileToUpload;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.serenitybdd.screenplay.targets.Target;

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

	public static String getTextObject(Actor actor, Target target){
		return Text.of(target).viewedBy(actor).asString().trim();
	}
}
