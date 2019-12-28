package com.automationpractice.wappi.questions.orderwithcoupon;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.automationpractice.wappi.userinterface.orderwithcoupon.UseCouponCode.SUCCESSFULLY_ORDER_CONFIRM_LABEL;

public class EnterCouponCodeResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(SUCCESSFULLY_ORDER_CONFIRM_LABEL).viewedBy(actor).asString().trim();
	}

	public static EnterCouponCodeResult theEnterCouponCode() {
		return new EnterCouponCodeResult();
	}
}