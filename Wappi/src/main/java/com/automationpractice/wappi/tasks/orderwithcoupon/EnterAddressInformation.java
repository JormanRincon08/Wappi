package com.automationpractice.wappi.tasks.orderwithcoupon;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.createanaccount.YourAddressInformationPage.*;
import static com.automationpractice.wappi.utils.util.TransposeDataTable.transposeDataTable;

import com.automationpractice.wappi.models.createanaccount.YourAddressInformation;

import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class EnterAddressInformation implements Task {
    private DataTable addressInformation;

    public EnterAddressInformation(DataTable addressInformation) {
        this.addressInformation = addressInformation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        YourAddressInformation yourAddressInformation = transposeDataTable(YourAddressInformation.class, addressInformation);
        actor.attemptsTo(
                takeScreenshot("Registration Address Information Page"),
                Enter.theValue(yourAddressInformation.getFirstNameAddress()).into(FIRST_NAME_ADDRESS),
                Enter.theValue(yourAddressInformation.getLastNameAddress()).into(LAST_NAME_ADDRESS),
                Enter.theValue(yourAddressInformation.getCompany()).into(COMPANY),
                Enter.theValue(yourAddressInformation.getAddress()).into(ADDRESS),
                Enter.theValue(yourAddressInformation.getAddress2()).into(ADDRESS_2),
                Enter.theValue(yourAddressInformation.getCity()).into(CITY),
                SelectFromOptions.byVisibleText(yourAddressInformation.getState()).from(STATE),
                Enter.theValue(yourAddressInformation.getZipPostalCode()).into(ZIP_POSTAL_CODE),
                SelectFromOptions.byVisibleText(yourAddressInformation.getCountry()).from(COUNTRY),
                Enter.theValue(yourAddressInformation.getAdditionalInformation()).into(ADDITIONAL_INFORMATION),
                Enter.theValue(yourAddressInformation.getHomePhone()).into(HOME_PHONE),
                Enter.theValue(yourAddressInformation.getMobilePhone()).into(MOBILE_PHONE),
                Enter.theValue(yourAddressInformation.getAddressAlias()).into(ADDRESS_ALIAS),
                Click.on(REGISTER)
        );
    }

    public static EnterAddressInformation inRegisterAddressInformationPageEnterThe(DataTable addressInformation) {
        return new EnterAddressInformation(addressInformation);
    }
}
