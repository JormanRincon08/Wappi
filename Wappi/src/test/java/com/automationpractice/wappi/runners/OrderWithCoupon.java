package com.automationpractice.wappi.runners;

import org.junit.runner.RunWith;

import com.automationpractice.wappi.utils.poi.DataToFeature;
import com.automationpractice.wappi.utils.runTest.BeforeSuite;
import com.automationpractice.wappi.utils.runTest.CustomRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CustomRunner.class)
@CucumberOptions(features = "src/test/resources/features/login_signout.feature",
				 //tags = "@Fail",
				 snippets = SnippetType.CAMELCASE, 
				 plugin = { "json:target/cucumber_json/cucumber.json" }, 
				 glue = { "com.automationpractice.wappi.stepdefinitions" })

public class OrderWithCoupon {

	private OrderWithCoupon() {}
	
	@BeforeSuite
	public static void test() {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}