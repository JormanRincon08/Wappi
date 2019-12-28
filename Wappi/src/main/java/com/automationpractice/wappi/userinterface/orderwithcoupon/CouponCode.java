package com.automationpractice.wappi.userinterface.orderwithcoupon;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CouponCode extends PageObject {
	public static final Target COUPON_CODE = Target.the("Coupon Code").located(By.xpath("//span[@id='coupon-code']"));
	public static final Target CLOSE_COUPON_MODAL = Target.the("Close Coupon Code Modal").located(By.xpath("//div[@id='coupon-modal']//span[@class='close']"));
}
