package com.automationpractice.wappi.userinterface.general;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
	public static final Target USER_NAME = Target.the("User Name").located(By.xpath("//input[@id='username']"));
	public static final Target PASSWORD = Target.the("Password").located(By.xpath("//input[@id='password']"));
	public static final Target SUBMIT_BUTTON = Target.the("Submit Login").located(By.id("button-login"));

	public static final Target USER_NAME_ERROR_LABEL = Target.the("User Name Error Label").located(By.id("e-username"));
}
