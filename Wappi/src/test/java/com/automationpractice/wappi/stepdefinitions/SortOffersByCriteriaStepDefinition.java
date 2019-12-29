package com.automationpractice.wappi.stepdefinitions;

import com.automationpractice.wappi.utils.util.Setup;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.automationpractice.wappi.questions.sortoffersbycriteria.SortResult.theSortResultWith;
import static com.automationpractice.wappi.tasks.sortoffersbycriteria.OrderByCriteria.orderByCriteria;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SortOffersByCriteriaStepDefinition extends Setup {

    private Actor client = Actor.named("Client");

    @Before
    public void setup() {
        setupBrowser();
        setupUser(client);
    }

    @When("^I click the on the criteria \"([^\"]*)\" to be sorted according to the number of clicks (\\d+)$")
    public void iClickTheOnTheCriteriaToBeSortedAccordingToTheNumberOfClicks(String criteria, int clickQuantity) {
        client.attemptsTo(orderByCriteria(criteria, clickQuantity));
    }

    @Then("^verify that the number of clicks (\\d+) corresponds to the appropriate sort type \"([^\"]*)\"$")
    public void verifyThatTheNumberOfClicksCorrespondsToTheAppropriateSortType(int clickQuantity, String sortExpected) {
        client.should(seeThat(theSortResultWith(clickQuantity), equalTo(sortExpected)));
    }
}
