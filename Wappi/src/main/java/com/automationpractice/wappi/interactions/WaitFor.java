package com.automationpractice.wappi.interactions;

import static com.automationpractice.wappi.utils.util.Util.waitForSomeTime;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class WaitFor implements Interaction {

    private int seconds;

    private WaitFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        waitForSomeTime(seconds);
    }

    public static WaitFor waitFor(int seconds){
        return new WaitFor(seconds);
    }
}
