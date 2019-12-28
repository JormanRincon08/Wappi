package com.automationpractice.wappi.tasks.orderwithcoupon;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.CouponCode.CLOSE_COUPON_MODAL;
import static com.automationpractice.wappi.utils.util.Const.ONE_SECOND;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class CloseGetCouponModal implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        waitForSomeTimeUtil(ONE_SECOND);
        actor.attemptsTo(
                takeScreenshot("Coupon Code"),
                Click.on(CLOSE_COUPON_MODAL)
        );
    }

    public static CloseGetCouponModal closeGetCouponWelcomeModal() {
        return new CloseGetCouponModal();
    }
}
