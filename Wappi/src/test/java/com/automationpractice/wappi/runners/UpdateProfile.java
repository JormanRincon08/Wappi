package com.automationpractice.wappi.runners;

import com.automationpractice.wappi.utils.poi.DataToFeature;
import com.automationpractice.wappi.utils.runtest.BeforeSuite;
import com.automationpractice.wappi.utils.runtest.CustomRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(CustomRunner.class)
@CucumberOptions(features = "src/test/resources/features/update_profile.feature",
				 //tags = "@FieldsRequired",
				 snippets = SnippetType.CAMELCASE, 
				 plugin = { "json:target/cucumber_json/cucumber.json" }, 
				 glue = { "com.automationpractice.wappi.stepdefinitions" })

public class UpdateProfile {

	private UpdateProfile() {}
	
	@BeforeSuite
	public static void test() {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}
