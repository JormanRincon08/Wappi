package com.automationpractice.wappi.tasks.orderwithcoupon;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.general.MainPage.LOGOUT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectLoginMainPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                takeScreenshot("Main Page"),
                Click.on(LOGOUT)
        );
    }

    public static SelectLoginMainPage goToTheRegistry() {
        return new SelectLoginMainPage();
    }
}
