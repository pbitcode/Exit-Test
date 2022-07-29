package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AppPage;
import pages.CustomTitlePage;
import pages.HomePage;
import resources.BaseClass;

public class CustomTitle extends BaseClass{	
	
	HomePage home_page = new HomePage();
	AppPage app_page = new AppPage();
	CustomTitlePage custom_title_page = new CustomTitlePage();
	
	@Given("^User is on Custom Title Page$")
	public void user_is_on_Custom_Title_Page() throws Throwable {
		newStep("Clicking on App");
	    home_page.goToAppPage();
	    
	    newStep("Clicking on Activity");
	    app_page.goToActivity();;
		
		newStep("Clicking on Custom Title");
		app_page.goToCustomTitle();;
	}

	@When("^User enter the Title as \"([^\"]*)\" in the Left Title Text Box$")
	public void user_enter_the_Title_as_in_the_Left_Title_Text_Box(String arg1) throws Throwable {
		newStep("Enter the Title in the Left Title Text Box");
	    custom_title_page.enterLeftTitle(arg1);
	}

	@When("^Clicks on the Change Left Title Button$")
	public void clicks_on_the_Change_Left_Title_Button() throws Throwable {
		newStep("Clicking on Change Left Title Button");
		custom_title_page.clickOnChangeLeftTitleButton();
	}

	@Then("^The entered \"([^\"]*)\" should be displayed as the Left Title$")
	public void the_entered_should_be_displayed_as_the_Left_Title(String arg1) throws Throwable {
		newStep("Verifying that the Left Title has been changed to the entered Title");
		Assert.assertEquals(arg1, custom_title_page.getLeftTitle().getText());
	}	
	
	@When("^User enter the Title as \"([^\"]*)\" in the Right Title Text Box$")
	public void user_enter_the_Title_as_in_the_Right_Title_Text_Box(String arg1) throws Throwable {
		newStep("Enter the Title in the Right Title Text Box");
	    custom_title_page.enterRightTitle(arg1);
	}

	@When("^Clicks on the Change Right Title Button$")
	public void clicks_on_the_Change_Right_Title_Button() throws Throwable {
		newStep("Clicking on Change Right Title Button");
		custom_title_page.clickOnChangeRightTitleButton();
	}

	@Then("^The entered \"([^\"]*)\" should be displayed as the Right Title$")
	public void the_entered_should_be_displayed_as_the_Right_Title(String arg1) throws Throwable {
		newStep("Verifying that the Right Title has been changed to the entered Title");
		Assert.assertEquals(arg1, custom_title_page.getRightTitle().getText());
	}

}
