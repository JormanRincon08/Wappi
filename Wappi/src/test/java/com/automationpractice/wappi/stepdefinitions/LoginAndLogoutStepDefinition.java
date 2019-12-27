package com.automationpractice.wappi.stepdefinitions;

import com.automationpractice.wappi.utils.util.Setup;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.automationpractice.wappi.questions.loginandlogout.LoginAndLogoutErrorResult.theLoginErrorResultIs;
import static com.automationpractice.wappi.questions.loginandlogout.LoginAndLogoutResult.theLoginAndLogoutResultIs;
import static com.automationpractice.wappi.tasks.loginandlogout.LoginTask.inLoginPageEnterThe;
import static com.automationpractice.wappi.tasks.loginandlogout.LogoutTask.inMainPageLogoutSession;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginAndLogoutStepDefinition extends Setup {

    private Actor client = Actor.named("Client");

    @Before
    public void setup() {
        setupBrowser();
        setupUser(client);
    }

    @When("^I enter my credentials$")
    public void iEnterMyCredentials(DataTable credentials) {
        client.attemptsTo(inLoginPageEnterThe(credentials));
    }

    @When("^I close the session$")
    public void iCloseTheSession() {
        client.attemptsTo(inMainPageLogoutSession());
    }

    @Then("^I validate the session closure$")
    public void iValidateTheSessionClosure() {
        client.should(seeThat(theLoginAndLogoutResultIs(), equalTo(true)));
    }

    @Then("^I validate the login fail with the message \"([^\"]*)\"$")
    public void iValidateTheLoginFailWithTheMessage(String expectedResult) {
        client.should(seeThat(theLoginErrorResultIs(), equalTo(expectedResult)));
    }
}
