package com.automationpractice.wappi.utils.util;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import static com.automationpractice.wappi.tasks.general.OpenBrowser.openTheBrowserOn;

import org.openqa.selenium.WebDriver;

import com.automationpractice.wappi.userinterface.general.LoginPage;

public class Setup {
    @Managed(uniqueSession = true)
    private WebDriver browser;

    @Steps
    private LoginPage loginPage;

    protected void setupBrowser(){
        this.browser.manage().deleteAllCookies();
        this.browser.manage().window().maximize();
    }

    protected void setupUser(Actor actor){
        browseTheWeb(actor);
        actor.wasAbleTo(
                openTheBrowserOn(loginPage)
        );
    }

    private void browseTheWeb(Actor actor){
        actor.can(BrowseTheWeb.with(browser));
    }
}
