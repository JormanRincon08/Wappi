package com.automationpractice.wappi.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.userinterface.general.MainPage.LOGOUT;

public class Logout implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGOUT)
        );
    }

    public static Logout logoutSession(){
        return new Logout();
    }
}
