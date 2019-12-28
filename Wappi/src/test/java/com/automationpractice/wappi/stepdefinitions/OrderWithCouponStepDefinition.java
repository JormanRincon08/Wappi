package com.automationpractice.wappi.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import com.automationpractice.wappi.utils.util.Setup;

import static com.automationpractice.wappi.questions.orderwithcoupon.EnterCouponCodeResult.theEnterCouponCode;
import static com.automationpractice.wappi.questions.orderwithcoupon.GetCouponCode.getCouponCode;
import static com.automationpractice.wappi.tasks.loginandlogout.LogoutTask.inMainPageLogoutSession;
import static com.automationpractice.wappi.tasks.orderwithcoupon.CloseGetCouponModal.closeGetCouponWelcomeModal;
import static com.automationpractice.wappi.tasks.orderwithcoupon.CloseOrderConfirmModal.closeOrderConfirmModal;
import static com.automationpractice.wappi.tasks.orderwithcoupon.EnterCouponCodeDiscount.inOrderConfirmEnterThe;
import static com.automationpractice.wappi.tasks.orderwithcoupon.SelectGetCouponOption.selectGetCouponWelcomeOption;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class OrderWithCouponStepDefinition extends Setup {

    private Actor client = Actor.named("Client");
    private String welcomeCouponCode;

    @Before
    public void setup() {
        setupBrowser();
        setupUser(client);
    }

    @When("^I get the welcome coupon code$")
    public void iGetTheWelcomeCouponCode() {
        client.attemptsTo(selectGetCouponWelcomeOption());
        welcomeCouponCode = getCouponCode().answeredBy(client);
        client.attemptsTo(closeGetCouponWelcomeModal());
    }


    @When("^I place an \"([^\"]*)\" order with the discount code$")
    public void iPlaceAnOrderWithTheDiscountCode(String offer) {
        client.attemptsTo(inOrderConfirmEnterThe(offer, welcomeCouponCode));
    }

    @Then("^I value that the order has been correctly executed \"([^\"]*)\"$")
    public void iValueThatTheOrderHasBeenCorrectlyExecuted(String expectedValue) {
        client.should(seeThat(theEnterCouponCode(), containsString(expectedValue)));
        client.attemptsTo(closeOrderConfirmModal(), inMainPageLogoutSession());
    }
}
