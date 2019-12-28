package com.automationpractice.wappi.tasks.updateprofile;

import com.automationpractice.wappi.models.updateprofile.UpdateProfileModel;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage.*;
import static com.automationpractice.wappi.utils.util.Const.MALE_VALUE;
import static com.automationpractice.wappi.utils.util.Const.THREE_SECONDS;
import static com.automationpractice.wappi.utils.util.TransposeDataTable.transposeDataTable;
import static com.automationpractice.wappi.utils.util.Util.isNullOrEmpty;
import static com.automationpractice.wappi.utils.util.Util.waitForSomeTimeUtil;

public class UpdateProfile implements Task {
    private DataTable userProfileInformation;

    public UpdateProfile(DataTable userProfileInformation) {
        this.userProfileInformation = userProfileInformation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        UpdateProfileModel updateProfileModel = transposeDataTable(UpdateProfileModel.class, userProfileInformation);
        actor.attemptsTo(
                takeScreenshot("Update Information Profile User"),

                Check.whether(isNullOrEmpty(updateProfileModel.getImage()))
                        .andIfSo(
                                //uploadFile(BrowseTheWeb.as(actor).getDriver(),"//input[@id='image']", updateProfileModel.getImage())
                                //Upload.theFile(Paths.get(updateProfileModel.getImage())).to(IMAGE)
                                //Enter.keyValues(updateProfileModel.getImage()).into(IMAGE)
                        ),
                Enter.theValue(updateProfileModel.getFirstName()).into(FIRST_NAME),
                Enter.theValue(updateProfileModel.getLastName()).into(LAST_NAME),
                Enter.theValue(updateProfileModel.getBornDate()).into(BORN_DATE),
                SelectFromOptions.byVisibleText(updateProfileModel.getCountry().trim()).from(COUNTRY),
                Check.whether(updateProfileModel.getGender().trim().toLowerCase().equalsIgnoreCase(MALE_VALUE.toLowerCase()))
                        .andIfSo(
                                Click.on(MALE))
                        .otherwise(
                                Click.on(FEMALE)),
                takeScreenshot("Successful update data"),
                Click.on(SAVE)
        );
        waitForSomeTimeUtil(THREE_SECONDS);
    }

    public static UpdateProfile inProfilePageEnterThe(DataTable userProfileInformation) {
        return new UpdateProfile(userProfileInformation);
    }
}
