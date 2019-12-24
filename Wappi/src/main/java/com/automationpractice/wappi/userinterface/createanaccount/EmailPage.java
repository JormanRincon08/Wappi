package com.automationpractice.wappi.userinterface.createanaccount;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EmailPage extends PageObject {
	public static final Target EMAIL_ADDRESS = Target.the("Email Address").located(By.id("email_create"));
	public static final Target SUBMIT_CREATE = Target.the("Submit Button Create").located(By.id("SubmitCreate"));
}
