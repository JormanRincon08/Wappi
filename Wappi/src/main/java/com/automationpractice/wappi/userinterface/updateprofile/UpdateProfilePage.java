package com.automationpractice.wappi.userinterface.updateprofile;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfilePage extends PageObject {
	public static final Target IMAGE = Target.the("Image").located(By.xpath("//input[@id='image']"));
	public static final String INPUT_FILE = "//input[@id='image']";
	public static final Target FIRST_NAME = Target.the("First Name").located(By.xpath("//input[@id='name']"));
	public static final Target LAST_NAME = Target.the("Last Name").located(By.xpath("//input[@id='lastName']"));
	public static final Target BORN_DATE = Target.the("Born Date").located(By.xpath("//input[@id='bornDate']"));
	public static final Target COUNTRY = Target.the("Country").located(By.xpath("//select[@id='country']"));
	public static final Target MALE = Target.the("Male Gender").located(By.xpath("//input[@id='Male']"));
	public static final Target FEMALE = Target.the("Female Gender").located(By.xpath("//input[@id='Female']"));
	public static final Target SAVE = Target.the("Submit Button Save").located(By.xpath("//button[@id='save-profile']"));

	public static final Target MANDATORY_IMAGE = Target.the("Mandatory Image").located(By.xpath("//span[@id='e-image' and @class='error-message']"));
	public static final Target MANDATORY_FIRST_NAME = Target.the("Mandatory First Name").located(By.xpath("//span[@id='e-name' and @class='error-message']"));
	public static final Target MANDATORY_BORN_DATE = Target.the("Mandatory Born Date").located(By.xpath("//span[@id='e-bornDate' and @class='error-message']"));
	public static final Target MANDATORY_COUNTRY = Target.the("Mandatory Country").located(By.xpath("//span[@id='e-country' and @class='error-message']"));
	public static final Target MANDATORY_GENDER = Target.the("Mandatory Gender").located(By.xpath("//span[@id='e-genre' and @class='error-message']"));

	public static WebElement getUploadWebElementById(String id, WebDriver driver) {
		return driver.findElement(By.xpath(id));
	}
}
