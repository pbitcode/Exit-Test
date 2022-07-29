package Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import resources.BaseClass;

public class Hooks extends BaseClass{
	
	//Logs the Start of the Test and also starts the Android Driver
	@Before
	public void beforeScenario(Scenario scenario) {
		startTest(scenario.getName());
		Step = "Starting Android Driver";
		startAndroidDriver();
	}
	
	//Logs the End of the test and also calls the logError if there if test case fails and stops the Android Driver
	@After
	public void afterScenario(Scenario scenario) throws IllegalArgumentException, IllegalAccessException {
		
		if(scenario.isFailed())
			logError(scenario);
		else
			pass();
			
		stopAndroidDriver();		
		endTest();
	}
	
	

}
