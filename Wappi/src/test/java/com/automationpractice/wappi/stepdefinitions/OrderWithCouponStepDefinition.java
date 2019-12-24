package com.automationpractice.wappi.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;

import static com.automationpractice.wappi.questions.RegisterErrorResult.theRegisterErrorResultIs;
import static com.automationpractice.wappi.questions.RegisterResult.theRegisterResultIs;
import static com.automationpractice.wappi.tasks.orderwithcoupon.EnterAddressInformation.inRegisterAddressInformationPageEnterThe;
import static com.automationpractice.wappi.tasks.orderwithcoupon.EnterEmail.inEmailPageEnterThe;
import static com.automationpractice.wappi.tasks.orderwithcoupon.EnterPersonalInformation.inRegisterPersonalInformationPageEnterThe;
import static com.automationpractice.wappi.tasks.orderwithcoupon.SelectLoginMainPage.goToTheRegistry;
import static org.hamcrest.CoreMatchers.equalTo;

import com.automationpractice.wappi.utils.util.Setup;

public class OrderWithCouponStepDefinition extends Setup {

    private Actor client = Actor.named("Client");

    @Before
    public void setup() {
        setupBrowser();
        setupUser(client);
    }

    @Given("^that I want to enter the registration section$")
    public void thatIWantToEnterTheRegistrationSection() {
        client.attemptsTo(goToTheRegistry());
    }

    @Given("^enter the email \"([^\"]*)\" to register$")
    public void enterTheEmailToRegister(String email) {
        client.attemptsTo(inEmailPageEnterThe(email));
    }

    @When("^I enter my personal information$")
    public void iEnterMyPersonalInformation(DataTable personalInformation) {
        client.attemptsTo(inRegisterPersonalInformationPageEnterThe(personalInformation));
    }

    @When("^enter my address information$")
    public void enterMyAddressInformation(DataTable addressInformation) {
        client.attemptsTo(inRegisterAddressInformationPageEnterThe(addressInformation));
    }

    @Then("^I must validate the expected result \"([^\"]*)\"$")
    public void iMustValidateTheExpectedResult(String expectedResult) {
        client.should(GivenWhenThen.seeThat(theRegisterResultIs(), equalTo(expectedResult)));
    }

    @Then("^I must validate the error expected result \"([^\"]*)\"$")
    public void iMustValidateTheErrorExpectedResult(String expectedFailResult) {
        client.should(GivenWhenThen.seeThat(theRegisterErrorResultIs(), equalTo(expectedFailResult)));
    }
}
