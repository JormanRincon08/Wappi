package com.automationpractice.wappi.tasks.loginandlogout;

import com.automationpractice.wappi.interactions.Login;
import com.automationpractice.wappi.models.createanaccount.PersonalInformation;
import com.automationpractice.wappi.models.general.User;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automationpractice.wappi.interactions.Login.loginWith;
import static com.automationpractice.wappi.userinterface.general.LoginPage.*;
import static com.automationpractice.wappi.utils.util.TransposeDataTable.transposeDataTable;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTime;

public class LoginTask implements Task {

    private DataTable credentials;

    public LoginTask(DataTable credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        User user = transposeDataTable(User.class, credentials);
        actor.attemptsTo(loginWith(user));
        waitForSomeTime(3);
    }

    public static LoginTask inLoginPageEnterThe(DataTable credentials) {
        return new LoginTask(credentials);
    }
}
