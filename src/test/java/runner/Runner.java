package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import resources.BaseClass;

@CucumberOptions(
	features = "src/test/java/features",
	glue = {"stepDefinitions","Hooks"},
	plugin = { "pretty", "html:target/cucumber-reports" }
)

public class Runner extends AbstractTestNGCucumberTests{
	
	BaseClass obj = new BaseClass();
	
	//Used for starting test resources
	@BeforeSuite
	public void beforeSuite() {
		obj.setup();
	}
	
	//Used for closing resources
	@AfterSuite
	public void afterSuite() {
		obj.teardown();
	}
}