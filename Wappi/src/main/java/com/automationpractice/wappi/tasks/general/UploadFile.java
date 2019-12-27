package com.automationpractice.wappi.tasks.general;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.pages.components.FileToUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadFile implements Task {

    private WebDriver driver;
    private String idElement;
    private String pathFile;

    public UploadFile(WebDriver driver, String idElement, String pathFile) {
        this.driver = driver;
        this.idElement = idElement;
        this.pathFile = pathFile;
    }

    public static UploadFile uploadFile(WebDriver driver, String idElement, String pathFile) {
        return new UploadFile(driver, idElement, pathFile);
    }

    /*public static UploadFile uploadFile(WebDriver driver, String idElement, String pathFile) {
        return instrumented(UploadFile.class, driver, idElement, pathFile);
    }*/

    @Override
    public <T extends Actor> void performAs(T actor) {
        myUploadFile(driver, idElement, pathFile);
    }

    public void myUploadFile(WebDriver driver, String idElement, String pathFile) {
        WebElement webElement = getUploadWebElementById(idElement, driver);
        FileToUpload fileToUpload = new FileToUpload(driver, pathFile);
        fileToUpload.fromLocalMachine().to(webElement);
    }

    public static WebElement getUploadWebElementById(String id, WebDriver driver) {
        return driver.findElement(By.xpath(id));
    }
}
