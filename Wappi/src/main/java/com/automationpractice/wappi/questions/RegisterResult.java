package com.automationpractice.wappi.questions;

import static com.automationpractice.wappi.userinterface.createanaccount.PersonalInformationPage.SUCCESSFULLY_REGISTER_LABEL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegisterResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(SUCCESSFULLY_REGISTER_LABEL).viewedBy(actor).asString().trim();
	}

	public static RegisterResult theRegisterResultIs() {
		return new RegisterResult();
	}
}