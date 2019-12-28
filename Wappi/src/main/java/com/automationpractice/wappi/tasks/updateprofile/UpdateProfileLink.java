package com.automationpractice.wappi.tasks.updateprofile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.userinterface.general.MainPage.PROFILE;
import static com.automationpractice.wappi.utils.util.Const.TWO_SECONDS;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class UpdateProfileLink implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PROFILE));
        waitForSomeTimeUtil(TWO_SECONDS);
    }

    public static UpdateProfileLink inMainPageGoToProfileSession() {
        return new UpdateProfileLink();
    }
}
