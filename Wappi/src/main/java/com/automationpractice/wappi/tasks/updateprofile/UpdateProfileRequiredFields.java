package com.automationpractice.wappi.tasks.updateprofile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage.SAVE;
import static com.automationpractice.wappi.utils.util.Const.THREE_SECONDS;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class UpdateProfileRequiredFields implements Task {

    private UpdateProfileRequiredFields() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        takeScreenshot("Update Information Profile User");
        actor.attemptsTo(
                takeScreenshot("Update Information Profile User"),
                Click.on(SAVE),
                takeScreenshot("Required fields")
        );
        waitForSomeTimeUtil(THREE_SECONDS);
    }

    public static UpdateProfileRequiredFields inProfileClickSave() {
        return new UpdateProfileRequiredFields();
    }
}
