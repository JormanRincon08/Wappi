package com.automationpractice.wappi.userinterface.createanaccount;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class YourAddressInformationPage extends PageObject {
	public static final Target FIRST_NAME_ADDRESS = Target.the("First Name").located(By.id("firstname"));
	public static final Target LAST_NAME_ADDRESS = Target.the("Last Name").located(By.id("lastname"));
	public static final Target COMPANY = Target.the("Company").located(By.id("company"));
	public static final Target ADDRESS = Target.the("Address 1").located(By.id("address1"));
	public static final Target ADDRESS_2 = Target.the("Address 2").located(By.id("address2"));
	public static final Target CITY = Target.the("City").located(By.id("city"));
	public static final Target STATE = Target.the("State").located(By.id("id_state"));
	public static final Target ZIP_POSTAL_CODE = Target.the("Zip/Postal Code").located(By.id("postcode"));
	public static final Target COUNTRY = Target.the("Country").located(By.id("id_country"));
	public static final Target ADDITIONAL_INFORMATION = Target.the("other").located(By.id("other"));
	public static final Target HOME_PHONE = Target.the("Home Phone").located(By.id("phone"));
	public static final Target MOBILE_PHONE = Target.the("Mobile Phone").located(By.id("phone_mobile"));
	public static final Target ADDRESS_ALIAS = Target.the("Assign An Address Alias For Future Reference").located(By.id("alias"));
	public static final Target REGISTER = Target.the("Submit Button Register").located(By.id("submitAccount"));
}
