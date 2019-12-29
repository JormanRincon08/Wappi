package com.automationpractice.wappi.questions.sortoffersbycriteria;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.wappi.utils.util.Const.FALLING_VALUE;
import static com.automationpractice.wappi.utils.util.Const.UPWARD_VALUE;

public class SortResult implements Question<String> {

	private int clickQuantity;

	public SortResult(int clickQuantity) {
		this.clickQuantity = clickQuantity;
	}

	@Override
	public String answeredBy(Actor actor) {
		return clickQuantity % 2 == 0 ? FALLING_VALUE : UPWARD_VALUE;
	}

	public static SortResult theSortResultWith(int clickQuantity) {
		return new SortResult(clickQuantity);
	}
}