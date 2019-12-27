package com.automationpractice.wappi.userinterface.orderwithcoupon;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalInformationPage extends PageObject {
	public static final Target TITLE_MR = Target.the("Mr.").located(By.id("id_gender1"));
	public static final Target TITLE_MRS = Target.the("Mrs.").located(By.id("id_gender2"));
	public static final Target FIRST_NAME = Target.the("Customer First Name").located(By.id("customer_firstname"));
	public static final Target LAST_NAME = Target.the("Customer Last Name").located(By.id("customer_lastname"));
	public static final Target EMAIL = Target.the("Email").located(By.id("email"));
	public static final Target PASSWORD = Target.the("Password").located(By.id("passwd"));
	public static final Target DATE_OF_BIRTH_DAY = Target.the("Date Of Birth Day").located(By.id("days"));
	public static final Target DATE_OF_BIRTH_MONTH = Target.the("Date Of Birth Month").located(By.id("months"));
	public static final Target DATE_OF_BIRTH_YEAR = Target.the("Date Of Birth Year").located(By.id("years"));
	public static final Target SIGN_NEWSLETTER = Target.the("Sign Up For Our Newsletter!").located(By.id("newsletter"));
	public static final Target RECEIVE_OFFERS = Target.the("Receive Special Offers From Our Partners!")
			.located(By.id("optin"));

	public static final Target SUCCESSFULLY_REGISTER_LABEL = Target.the("Register User Successfully").locatedBy("//h1[@class='page-heading']");

	public static final Target ERROR_REGISTER_LABEL = Target.the("Register User Error").locatedBy("//div[@class='alert alert-danger']//ol//li");
}
