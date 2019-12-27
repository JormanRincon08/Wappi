package com.automationpractice.wappi.tasks.orderwithcoupon;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.orderwithcoupon.PersonalInformationPage.*;
import static com.automationpractice.wappi.utils.util.Const.*;
import static com.automationpractice.wappi.utils.util.TransposeDataTable.transposeDataTable;

import com.automationpractice.wappi.models.orderwithcoupon.PersonalInformation;

import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;

public class EnterPersonalInformation implements Task {
    private DataTable personalInformation;

    public EnterPersonalInformation(DataTable personalInformation) {
        this.personalInformation = personalInformation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        PersonalInformation personalInformationModel = transposeDataTable(PersonalInformation.class, personalInformation);
        actor.attemptsTo(
                takeScreenshot("Registration Personal Information Page"),
                Check.whether(personalInformationModel.getTitle().trim().toLowerCase().equalsIgnoreCase(TRUE.toLowerCase()))
                        .andIfSo(
                                Click.on(TITLE_MR))
                        .otherwise(
                                Click.on(TITLE_MRS)),
                Enter.theValue(personalInformationModel.getFirstName()).into(FIRST_NAME),
                Enter.theValue(personalInformationModel.getLastName()).into(LAST_NAME),
                Enter.theValue(personalInformationModel.getEmail()).into(EMAIL),
                Enter.theValue(personalInformationModel.getPassword()).into(PASSWORD),
                SelectFromOptions.byValue(personalInformationModel.getDateOfBirthDay().trim()).from(DATE_OF_BIRTH_DAY),
                SelectFromOptions.byVisibleText(personalInformationModel.getDateOfBirthMonth() + " ").from(DATE_OF_BIRTH_MONTH),
                SelectFromOptions.byValue(personalInformationModel.getDateOfBirthYear()).from(DATE_OF_BIRTH_YEAR),
                Check.whether(personalInformationModel.getSignNewsletter().trim().toLowerCase().equalsIgnoreCase(CHECK.toLowerCase()))
                        .andIfSo(
                                Click.on(SIGN_NEWSLETTER)),
                Check.whether(personalInformationModel.getReceiveOffers().trim().toLowerCase().equalsIgnoreCase(CHECK.toLowerCase()))
                        .andIfSo(
                                Click.on(RECEIVE_OFFERS)),
                takeScreenshot("Successful Result")
        );
    }

    public static EnterPersonalInformation inRegisterPersonalInformationPageEnterThe(DataTable personalInformation) {
        return new EnterPersonalInformation(personalInformation);
    }
}
