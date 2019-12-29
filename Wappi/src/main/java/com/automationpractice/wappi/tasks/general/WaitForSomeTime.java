package com.automationpractice.wappi.tasks.general;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitForSomeTime implements Task {

    private int seconds;

    public WaitForSomeTime(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        waitForSomeTimeUtil(seconds);
    }

    public static WaitForSomeTime waitForSomeTime(int seconds){
        return instrumented(WaitForSomeTime.class, seconds);
    }
}
