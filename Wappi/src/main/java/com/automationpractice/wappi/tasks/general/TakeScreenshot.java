package com.automationpractice.wappi.tasks.general;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TakeScreenshot implements Task {

	private String textEvidence;

	public TakeScreenshot(String textEvidence) {
		this.textEvidence = textEvidence;
	}

	@Step("{0} #textEvidence")
	public <T extends Actor> void performAs(T theActor) {
		Serenity.takeScreenshot();
	}

	public static TakeScreenshot takeScreenshot(String textEvidence) {
		return instrumented(TakeScreenshot.class, textEvidence);
	}

}
