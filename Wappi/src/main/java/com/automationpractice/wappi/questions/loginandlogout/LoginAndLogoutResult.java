package com.automationpractice.wappi.questions.loginandlogout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.wappi.userinterface.general.LoginPage.USER_NAME;

public class LoginAndLogoutResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return USER_NAME.resolveFor(actor).isPresent();
    }

    public static LoginAndLogoutResult theLoginAndLogoutResultIs() {
        return new LoginAndLogoutResult();
    }
}