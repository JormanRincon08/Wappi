package com.automationpractice.wappi.questions.loginandlogout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.automationpractice.wappi.userinterface.general.LoginPage.USER_NAME_ERROR_LABEL;

public class LoginAndLogoutErrorResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(USER_NAME_ERROR_LABEL).viewedBy(actor).asString();
	}

	public static LoginAndLogoutErrorResult theLoginErrorResultIs() {
		return new LoginAndLogoutErrorResult();
	}
}