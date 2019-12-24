package com.automationpractice.wappi.interactions;

import static com.automationpractice.wappi.userinterface.general.LoginPage.USER_NAME;
import static com.automationpractice.wappi.userinterface.general.LoginPage.PASSWORD;
import static com.automationpractice.wappi.userinterface.general.LoginPage.SUBMIT_BUTTON;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTime;

import com.automationpractice.wappi.models.general.User;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Interaction {

    private User user;

    public Login(User user){
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.user.getUserName()).into(USER_NAME),
                Enter.theValue(this.user.getPassword()).into(PASSWORD),
                Click.on(SUBMIT_BUTTON)
        );
    }

    public static Login loginWith(User user){
        return new Login(user);
    }
}
