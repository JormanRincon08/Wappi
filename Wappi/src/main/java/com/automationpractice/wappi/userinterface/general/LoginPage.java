package com.automationpractice.wappi.userinterface.general;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {
	public static final Target USER_NAME = Target.the("User Name").located(By.xpath("//input[@id='username']"));
	public static final Target PASSWORD = Target.the("Password").located(By.xpath("//input[@id='password']"));
	public static final Target SUBMIT_BUTTON = Target.the("Submit Login").located(By.id("button-login"));
}
