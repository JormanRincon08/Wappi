package com.automationpractice.wappi.tasks.orderwithcoupon;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.tasks.general.WaitForSomeTime.waitForSomeTime;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.UseCouponCode.CLOSE_CONFIRMATION_MODAL;
import static com.automationpractice.wappi.utils.util.Const.ONE_SECOND;

public class CloseOrderConfirmModal implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                takeScreenshot("Order Confirm Modal"),
                Click.on(CLOSE_CONFIRMATION_MODAL),
                waitForSomeTime(ONE_SECOND)
        );
    }

    public static CloseOrderConfirmModal closeOrderConfirmModal() {
        return new CloseOrderConfirmModal();
    }
}
