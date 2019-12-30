package com.automationpractice.wappi.tasks.general;

import com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.pages.components.FileToUpload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automationpractice.wappi.userinterface.updateprofile.UpdateProfilePage.getUploadWebElementById;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UploadFile implements Task {

    private WebDriver driver;
    private String xpathExpression;
    private String pathFile;

    public UploadFile(WebDriver driver, String xpathExpression, String pathFile) {
        this.driver = driver;
        this.xpathExpression = xpathExpression;
        this.pathFile = pathFile;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //actor.attemptsTo(WaitUntil.the(IMAGE, isVisible()));
        myUploadFile(driver, xpathExpression, pathFile);
    }

    public void myUploadFile(WebDriver driver, String xpathExpression, String pathFile) {
        WebElement webElement = getUploadWebElementById(xpathExpression, driver);
        FileToUpload fileToUpload = new FileToUpload(driver, pathFile);
        fileToUpload.fromLocalMachine().to(webElement);
    }

    public static UploadFile uploadFileIn(WebDriver driver, String xpathExpression, String pathFile) {
        return instrumented(UploadFile.class, driver, xpathExpression, pathFile);
    }
}
