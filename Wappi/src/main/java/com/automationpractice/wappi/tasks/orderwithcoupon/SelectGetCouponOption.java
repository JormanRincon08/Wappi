package com.automationpractice.wappi.tasks.orderwithcoupon;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.general.MainPage.GET_WELCOME_COUPON;

public class SelectGetCouponOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                takeScreenshot("Main Page"),
                Click.on(GET_WELCOME_COUPON)
        );
    }

    public static SelectGetCouponOption selectGetCouponWelcomeOption() {
        return new SelectGetCouponOption();
    }
}
