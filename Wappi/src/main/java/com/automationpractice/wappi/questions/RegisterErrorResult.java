package com.automationpractice.wappi.questions;

import static com.automationpractice.wappi.userinterface.orderwithcoupon.PersonalInformationPage.ERROR_REGISTER_LABEL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegisterErrorResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(ERROR_REGISTER_LABEL).viewedBy(actor).asString();
	}

	public static RegisterErrorResult theRegisterErrorResultIs() {
		return new RegisterErrorResult();
	}
}