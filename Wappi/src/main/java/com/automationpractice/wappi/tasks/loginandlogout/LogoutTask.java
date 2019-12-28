package com.automationpractice.wappi.tasks.loginandlogout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.automationpractice.wappi.interactions.Logout.logoutSession;
import static com.automationpractice.wappi.utils.util.Const.THREE_SECONDS;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class LogoutTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(logoutSession());
        waitForSomeTimeUtil(THREE_SECONDS);
    }

    public static LogoutTask inMainPageLogoutSession() {
        return new LogoutTask();
    }
}
