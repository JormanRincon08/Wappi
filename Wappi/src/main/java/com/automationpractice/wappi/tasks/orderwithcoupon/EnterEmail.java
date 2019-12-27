package com.automationpractice.wappi.tasks.orderwithcoupon;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.EmailPage.EMAIL_ADDRESS;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.EmailPage.SUBMIT_CREATE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterEmail implements Task {
    private String email;

    public EnterEmail(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                takeScreenshot("Registration Email Page"),
                Enter.theValue(email).into(EMAIL_ADDRESS),
                Click.on(SUBMIT_CREATE),
                takeScreenshot("Successful Result")
        );
    }

    public static EnterEmail inEmailPageEnterThe(String email) {
        return new EnterEmail(email);
    }
}
