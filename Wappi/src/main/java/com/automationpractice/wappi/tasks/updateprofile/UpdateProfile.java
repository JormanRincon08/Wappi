package com.automationpractice.wappi.tasks.updateprofile;

import com.automationpractice.wappi.models.updateprofile.UpdateProfileModel;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.pages.components.FileToUpload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automationpractice.wappi.tasks.general.TakeScreenshot.takeScreenshot;
import static com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage.*;
import static com.automationpractice.wappi.utils.util.Const.*;
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

        takeScreenshot("Update Information Profile User");
        UpdateProfileModel updateProfileModel = transposeDataTable(UpdateProfileModel.class, userProfileInformation);
        if (!isNullOrEmpty(updateProfileModel.getImage()))
            myUploadFile(BrowseTheWeb.as(actor).getDriver(), INPUT_FILE, updateProfileModel.getImage());

        actor.attemptsTo(
                Enter.theValue(updateProfileModel.getFirstName()).into(FIRST_NAME),
                Enter.theValue(updateProfileModel.getLastName()).into(LAST_NAME),
                Enter.theValue(updateProfileModel.getBornDate()).into(BORN_DATE),
                Check.whether(!isNullOrEmpty(updateProfileModel.getCountry()))
                        .andIfSo(SelectFromOptions.byVisibleText(updateProfileModel.getCountry().trim()).from(COUNTRY)),
                Check.whether(updateProfileModel.getGender().trim().toLowerCase().equalsIgnoreCase(MALE_VALUE.toLowerCase()))
                        .andIfSo(Click.on(MALE)),
                Check.whether(updateProfileModel.getGender().trim().toLowerCase().equalsIgnoreCase(FEMALE_VALUE.toLowerCase()))
                        .andIfSo(Click.on(FEMALE)),
                takeScreenshot("Successful update data"),
                Click.on(SAVE)
        );
        waitForSomeTimeUtil(THREE_SECONDS);
    }

    public void myUploadFile(WebDriver driver, String xpathExpression, String pathFile) {
        WebElement webElement = getUploadWebElementById(xpathExpression, driver);
        FileToUpload fileToUpload = new FileToUpload(driver, pathFile);
        fileToUpload.fromLocalMachine().to(webElement);
    }

    public static UpdateProfile inProfilePageEnterThe(DataTable userProfileInformation) {
        return new UpdateProfile(userProfileInformation);
    }
}
