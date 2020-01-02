package com.automationpractice.wappi.interactions;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.general.LoginPage.USER_NAME;
import static com.automationpractice.wappi.userinterface.general.LoginPage.PASSWORD;
import static com.automationpractice.wappi.userinterface.general.LoginPage.SUBMIT_BUTTON;

import com.automationpractice.wappi.models.general.UserModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Interaction {

    private UserModel user;

    public Login(UserModel user){
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                takeScreenshot("Login page"),
                Enter.theValue(this.user.getUserName()).into(USER_NAME),
                Enter.theValue(this.user.getPassword()).into(PASSWORD),
                takeScreenshot("Credentials entered"),
                Click.on(SUBMIT_BUTTON)
        );
    }

    public static Login loginWith(UserModel user){
        return new Login(user);
    }
}
