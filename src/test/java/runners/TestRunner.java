package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features= {"src\\test\\resources\\functionalTests\\End2End_Test.feature"},
	glue= {"stepDefinitions","hooks"},
	plugin= {"pretty","json:target/cucumber-reports/Cucumber.json",
			"junit:target/cucumber-reports/Cucumber.xml",
			"html:target/cucumber-reports/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome=true
)

public class TestRunner {

}
