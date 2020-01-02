package com.automationpractice.wappi.stepdefinitions;

import com.automationpractice.wappi.utils.util.Setup;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.automationpractice.wappi.questions.updateprofile.UpdateProfileRequiredFields.theUpdateProfileMandatoryResult;
import static com.automationpractice.wappi.questions.updateprofile.UpdateProfileResult.theUpdateProfileResultIs;
import static com.automationpractice.wappi.tasks.loginandlogout.LoginTask.inLoginPageEnterThe;
import static com.automationpractice.wappi.tasks.updateprofile.UpdateProfile.inProfilePageEnterThe;
import static com.automationpractice.wappi.tasks.updateprofile.UpdateProfileLink.inMainPageGoToProfileSession;
import static com.automationpractice.wappi.tasks.updateprofile.UpdateProfileRequiredFields.inProfileClickSave;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateProfileStepDefinition extends Setup {

    private Actor client = Actor.named("Client");

    @Before
    public void setup() {
        setupBrowser();
        setupUser(client);
    }

    @Given("^that I want to enter the page$")
    public void thatIWantToEnterThePage(DataTable credentials) {
        client.attemptsTo(inLoginPageEnterThe(credentials));
    }

    @When("^I enter the update profile section$")
    public void iEnterTheUpdateProfileSection() {
        client.attemptsTo(inMainPageGoToProfileSession());
    }

    @When("^I enter the data to modify$")
    public void iEnterTheDataToModify(DataTable userData) {
        client.attemptsTo(inProfilePageEnterThe(userData));
    }

    @Then("^I must validate the expected result of the update$")
    public void iMustValidateTheExpectedResultOfTheUpdate() {
        client.should(seeThat(theUpdateProfileResultIs(), equalTo(true)));
    }

    @When("^I not enter the data to modify$")
    public void iNotEnterTheDataToModify() {
        client.attemptsTo(inProfileClickSave());
    }

    @Then("^I validate that the fields not filled out are mandatory$")
    public void iValidateThatTheFieldsNotFilledOutAreMandatory() {
        client.should(seeThat(theUpdateProfileMandatoryResult()));
    }
}
