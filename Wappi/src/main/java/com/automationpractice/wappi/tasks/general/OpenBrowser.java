package com.automationpractice.wappi.tasks.general;

import com.automationpractice.wappi.exceptions.LoginExc;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.pages.PageObject;

import static com.automationpractice.wappi.exceptions.LoginExc.MESSAGE_PAGE_DO_NOT_LOADED;
import static com.automationpractice.wappi.userinterface.general.LoginPage.USER_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class OpenBrowser implements Task {

    private PageObject pageObject;

    public OpenBrowser(PageObject pageObject) {
        this.pageObject = pageObject;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(this.pageObject));
        actor.should(seeThat(the(USER_NAME), isPresent()).orComplainWith(LoginExc.class, MESSAGE_PAGE_DO_NOT_LOADED));
    }

    public static OpenBrowser openTheBrowserOn(PageObject pageObject) {
        return new OpenBrowser(pageObject);
    }
}
