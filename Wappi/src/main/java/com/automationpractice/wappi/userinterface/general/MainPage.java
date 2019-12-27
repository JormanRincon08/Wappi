package com.automationpractice.wappi.userinterface.general;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MainPage extends PageObject {

    public static final Target START = Target.the("Start").located(By.id("nav-bar-home"));
    public static final Target COUPONS = Target.the("Coupons").located(By.id("nav-bar-coupons"));
    public static final Target PROFILE = Target.the("Profile").located(By.id("nav-bar-profile"));

    public static final Target GET_WELCOME_COUPON = Target.the("Get Welcome Coupon").located(By.id("welcome-coupon"));
    public static final Target LOGOUT = Target.the("Logout").located(By.xpath("(//a[@id='nav-bar-logout'])[2]"));

    public static final Target DATE_ORDER_COLUMN = Target.the("Date Order").located(By.id("date-order"));
    public static final Target PRICE_ORDER_COLUMN = Target.the("Price Order").located(By.id("price-order"));
    public static final Target COMMERCE_ORDER_COLUMN = Target.the("Commerce Order").located(By.id("comerce-order"));

    public static final Target ASK_FOR_ACEITE_GIRASOL = Target.the("Ask For Aceite de Girasol").located(By.xpath("//td[text()='Aceite de Girasol']//..//button"));
	public static final Target ASK_FOR_JAMON_PREMIUM = Target.the("Ask For Jamón Premium").located(By.xpath("//td[text()='Jamón Premium']//..//button"));
	public static final Target ASK_FOR_PAN_TAJADO = Target.the("Ask For Pan Tajado").located(By.xpath("//td[text()='Pan tajado']//..//button"));

}
