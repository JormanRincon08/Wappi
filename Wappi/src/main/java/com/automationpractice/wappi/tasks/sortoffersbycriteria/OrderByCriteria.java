package com.automationpractice.wappi.tasks.sortoffersbycriteria;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.general.MainPage.*;
import static com.automationpractice.wappi.utils.util.Const.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OrderByCriteria implements Task {

    private String criteria;
    private int clickQuantity;

    public OrderByCriteria(String criteria, int clickQuantity) {
        this.criteria = criteria;
        this.clickQuantity = clickQuantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= clickQuantity; i++) {
            actor.attemptsTo(
                    takeScreenshot("Order by criteria: " + criteria + ", Click: " + i),
                    Check.whether(criteria.trim().toLowerCase().equalsIgnoreCase(ORDER_BY_DATE_VALUE.toLowerCase()))
                            .andIfSo(Click.on(DATE_ORDER_COLUMN)),
                    Check.whether(criteria.trim().toLowerCase().equalsIgnoreCase(ORDER_BY_PRICE_VALUE.toLowerCase()))
                            .andIfSo(Click.on(PRICE_ORDER_COLUMN)),
                    Check.whether(criteria.trim().toLowerCase().equalsIgnoreCase(ORDER_BY_COMMERCE_VALUE.toLowerCase()))
                            .andIfSo(Click.on(COMMERCE_ORDER_COLUMN))
                    );
        }
    }

    public static OrderByCriteria orderByCriteria(String criteria, int clickQuantity) {
        return instrumented(OrderByCriteria.class, criteria, clickQuantity);
    }
}
