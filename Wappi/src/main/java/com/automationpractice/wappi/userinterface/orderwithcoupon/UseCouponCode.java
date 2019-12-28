package com.automationpractice.wappi.userinterface.orderwithcoupon;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class UseCouponCode extends PageObject {
	public static final Target COUPON_CODE_FIELD = Target.the("Coupon Code Field").located(By.xpath("//input[@id='coupon']"));
	public static final Target ORDER_CONFIRM = Target.the("Submit Order Confirm").located(By.id("order-confirm"));
	public static final Target SUCCESSFULLY_ORDER_CONFIRM_LABEL = Target.the("Order Confirm Successfully").located(By.xpath("//p[@class='confirmation-modal-info']"));
	public static final Target CLOSE_CONFIRMATION_MODAL = Target.the("Close Confirmation Modal").located(By.xpath("//div[@id='confirmation-modal']//span[@class='close']"));
}
