package com.automationpractice.wappi.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/login_signout.feature",
				 //tags = "@Fail",
				 snippets = SnippetType.CAMELCASE, 
				 plugin = { "json:target/cucumber_json/cucumber.json" }, 
				 glue = { "com.automationpractice.wappi.stepdefinitions" })

public class LoginAndLogout {

	private LoginAndLogout() {}
}
