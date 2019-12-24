package com.automationpractice.wappi.interactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class KeyTab implements Interaction {

	private static final Logger LOGGER = Logger.getLogger(KeyTab.class);

	@Override
	public <T extends Actor> void performAs(T actor) {
		keyTabPress();
	}

	private void keyTabPress() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			LOGGER.info(e.getMessage(), e);
		}
	}

	public static KeyTab pressKeyTab() {
		return new KeyTab();
	}

}
