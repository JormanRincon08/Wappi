package com.automationpractice.wappi.questions.orderwithcoupon;

import static com.automationpractice.wappi.userinterface.orderwithcoupon.CouponCode.COUPON_CODE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class GetCouponCode implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(COUPON_CODE).viewedBy(actor).asString().trim();
	}

	public static GetCouponCode getCouponCode() {
		return new GetCouponCode();
	}
}