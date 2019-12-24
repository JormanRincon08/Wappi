package com.automationpractice.wappi.stepdefinitions;

import com.automationpractice.wappi.utils.util.Setup;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.automationpractice.wappi.tasks.loginandlogout.LoginTask.inLoginPageEnterThe;

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

    }

    @Then("^I validate the sesion closure$")
    public void iValidateTheSesionClosure() {

    }

    @Then("^I validate the login fail$")
    public void iValidateTheLoginFail() {

    }
}
