package com.automationpractice.wappi.runners;

import org.junit.runner.RunWith;

import com.automationpractice.wappi.utils.poi.DataToFeature;
import com.automationpractice.wappi.utils.runtest.BeforeSuite;
import com.automationpractice.wappi.utils.runtest.CustomRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CustomRunner.class)
@CucumberOptions(features = "src/test/resources/features/order_with_coupon.feature",
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
