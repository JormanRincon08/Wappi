package com.automationpractice.wappi.questions.updateprofile;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.wappi.userinterface.general.MainPage.OFFERS_MAIN_TITLE;

public class UpdateProfileResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return OFFERS_MAIN_TITLE.resolveFor(actor).isPresent();
    }

    public static UpdateProfileResult theUpdateProfileResultIs() {
        return new UpdateProfileResult();
    }
}