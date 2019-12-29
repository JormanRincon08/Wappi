package com.automationpractice.wappi.tasks.orderwithcoupon;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.tasks.general.WaitForSomeTime.waitForSomeTime;
import static com.automationpractice.wappi.userinterface.general.MainPage.*;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.UseCouponCode.COUPON_CODE_FIELD;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.UseCouponCode.ORDER_CONFIRM;
import static com.automationpractice.wappi.utils.util.Const.*;

public class EnterCouponCodeDiscount implements Task {
    private String offer;
    private String codeCoupon;

    public EnterCouponCodeDiscount(String offer, String codeCoupon) {
        this.offer = offer;
        this.codeCoupon = codeCoupon;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                takeScreenshot("Order Confirmation"),
                Check.whether(offer.trim().toLowerCase().equalsIgnoreCase(SUNFLOWER_OIL_VALUE.toLowerCase()))
                        .andIfSo(Click.on(ASK_FOR_SUNFLOWER_OIL)),
                Check.whether(offer.trim().toLowerCase().equalsIgnoreCase(HALVED_BREAD.toLowerCase()))
                        .andIfSo(Click.on(ASK_FOR_HALVED_BREAD)),
                Check.whether(offer.trim().toLowerCase().equalsIgnoreCase(PREMIUM_HAM.toLowerCase()))
                        .andIfSo(Click.on(ASK_FOR_PREMIUM_HAM)),
                waitForSomeTime(ONE_SECOND),
                Enter.theValue(codeCoupon).into(COUPON_CODE_FIELD),
                waitForSomeTime(ONE_SECOND),
                Click.on(ORDER_CONFIRM),
                takeScreenshot("Successful Order Confirmation"),
                waitForSomeTime(THREE_SECONDS)
        );
    }

    public static EnterCouponCodeDiscount inOrderConfirmEnterThe(String offer, String codeCoupon) {
        return new EnterCouponCodeDiscount(offer, codeCoupon);
    }
}
