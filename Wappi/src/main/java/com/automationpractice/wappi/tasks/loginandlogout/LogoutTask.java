package com.automationpractice.wappi.tasks.loginandlogout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.automationpractice.wappi.interactions.Logout.logoutSession;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTime;

public class LogoutTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(logoutSession());
        waitForSomeTime(3);
    }

    public static LogoutTask inMainPageLogoutSession() {
        return new LogoutTask();
    }
}
