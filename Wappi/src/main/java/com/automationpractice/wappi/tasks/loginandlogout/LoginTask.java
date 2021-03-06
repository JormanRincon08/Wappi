package com.automationpractice.wappi.tasks.loginandlogout;

import com.automationpractice.wappi.models.general.UserModel;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.automationpractice.wappi.interactions.Login.loginWith;
import static com.automationpractice.wappi.utils.util.Const.THREE_SECONDS;
import static com.automationpractice.wappi.utils.util.TransposeDataTable.transposeDataTable;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class LoginTask implements Task {

    private DataTable credentials;

    public LoginTask(DataTable credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel user = transposeDataTable(UserModel.class, credentials);
        actor.attemptsTo(loginWith(user));
        waitForSomeTimeUtil(THREE_SECONDS);
    }

    public static LoginTask inLoginPageEnterThe(DataTable credentials) {
        return new LoginTask(credentials);
    }
}
