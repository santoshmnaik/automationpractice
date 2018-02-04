package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features/",
		//tags = "@Sample", //This will be useful when we want to divide the overall suite in sub divisions like regression, smoke, functional etc
		format = {"pretty","json:report/jsonreports/ExecutionReportInJson.json","html:report/htmlreports"},
		glue = "stepDefinitions",
		monochrome = true,
		strict = true,
		dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests{
}
