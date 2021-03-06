package com.automationpractice.wappi.userinterface.general;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MainPage extends PageObject {

    public static final Target START = Target.the("Start").located(By.xpath("(//a[@id='nav-bar-home'])[2]"));
    public static final Target COUPONS = Target.the("Coupons").located(By.xpath("(//a[@id='nav-bar-coupons'])[2]"));
    public static final Target PROFILE = Target.the("Profile").located(By.xpath("(//a[@id='nav-bar-profile'])[2]"));

    public static final Target OFFERS_MAIN_TITLE = Target.the("Offers Main Title").located(By.xpath("//h1[@class='app-title' and text()='Ofertas']"));

    public static final Target GET_WELCOME_COUPON = Target.the("Get Welcome Coupon").located(By.xpath("(//button[@id='welcome-coupon'])[2]"));
    public static final Target LOGOUT = Target.the("Logout").located(By.xpath("(//a[@id='nav-bar-logout'])[2]"));

    public static final Target DATE_ORDER_COLUMN = Target.the("Date Order").located(By.id("date-order"));
    public static final Target PRICE_ORDER_COLUMN = Target.the("Price Order").located(By.id("price-order"));
    public static final Target COMMERCE_ORDER_COLUMN = Target.the("Commerce Order").located(By.id("comerce-order"));

    public static final Target ASK_FOR_SUNFLOWER_OIL = Target.the("Ask For Aceite de Girasol").located(By.xpath("//td[text()='Aceite de Girasol']//..//button"));
	public static final Target ASK_FOR_HALVED_BREAD = Target.the("Ask For Pan Tajado").located(By.xpath("//td[text()='Pan tajado']//..//button"));
    public static final Target ASK_FOR_PREMIUM_HAM = Target.the("Ask For Jamón Premium").located(By.xpath("//td[text()='Jamón Premium']//..//button"));
}
