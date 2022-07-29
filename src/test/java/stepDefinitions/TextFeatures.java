package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LogTextBoxPage;
import resources.BaseClass;

public class TextFeatures extends BaseClass{
	
	HomePage home_page = new HomePage();
	LogTextBoxPage log_text_page = new LogTextBoxPage();
	
	@Given("^User is on LogTextBox Page$")
	public void user_is_on_LogTextBox_Page() throws Throwable {
		newStep("Click on Text");
		home_page.goToTextPage();
		
		newStep("Click on LogTextBox");
		log_text_page.clickOnLogTextBox();
	}

	@When("^User clicks the Add Button (\\d+) times$")
	public void user_clicks_the_Add_Button_times(int arg1) throws Throwable {
		newStep("Click on Add Button");
		while(arg1>0) {
			log_text_page.clickOnAddLogTextButton();
			arg1--;
		}
	}

	@Then("^The respective text should be logged on the screen for (\\d+) times$")
	public void the_respective_text_should_be_logged_on_the_screen_for_times(int arg1) throws Throwable {
	    newStep("Verifying that the respective text has been logged "+arg1+" times");
	    String expected = "";
	    while(arg1>0) {
	    	expected += testdata.get("LogText") + "\n";
	    	arg1--;
	    }
	    String actual = log_text_page.getLogTextDisplayScreen().getText();
	    Assert.assertEquals(actual, expected);
	}

}
