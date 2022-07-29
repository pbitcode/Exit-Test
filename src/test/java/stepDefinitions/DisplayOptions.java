package stepDefinitions;

import java.util.ArrayList;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import pages.AppPage;
import pages.DisplayOptionsPage;
import pages.HomePage;
import resources.BaseClass;

public class DisplayOptions extends BaseClass{
	
	HomePage home_page = new HomePage();
	AppPage app_page = new AppPage();
	DisplayOptionsPage display_options_page = new DisplayOptionsPage();
	
	String Title = null;
	
	
	@Given("^User is on Display Options Page$")
	public void user_is_on_Display_Options_Page(){
	    newStep("Click on App");
	    home_page.goToAppPage();
	    
	    newStep("Click on Action Bar");
	    app_page.goToActionBar();
	    
	    newStep("Click on Display Options");
	    app_page.goToDisplayOptions();
	    
	}

	@When("^User Clicks on DISPLAY_SHOW_TITLE Button$")
	public void user_Clicks_on_DISPLAY_SHOW_TITLE_Button()  {
		newStep("Click on DISPLAY_SHOW_TITLE Button");
		display_options_page.clickOnDISPLAY_SHOW_TITLE_Button();
	}

	@Then("^The Title Disappears$")
	public void the_Title_Disappears()  {
		newStep("The Title should be INVISIBLE");
		try {
			display_options_page.getPageTitle();
		}catch(Exception e) {
			return;
		}
		//if the title is still visible we throw an exception
		throw new RuntimeException("The Title should have been INVISIBLE but is VISIBLE!!!!");
	}

	@Then("^The Title Reappears$")
	public void the_Title_Reappears()  {
		newStep("The Title should be VISIBLE");
		String ActualTitle = display_options_page.getPageTitle().getText();
		String ExpectedTitle = testdata.get("DisplayOptionsTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}	
	
	@When("^User Clicks on DISPLAY_SHOW_CUSTOM Button$")
	public void user_Clicks_on_DISPLAY_SHOW_CUSTOM_Button()  {
		newStep("Click on DISPLAY_SHOW_CUSTOM Button");
		display_options_page.clickOnDISPLAY_SHOW_CUSTOMButton();
	}

	@Then("^The Custom View Button Appears$")
	public void the_Custom_Button_Appears()  {
	    newStep("The Custom View Button Should Appear");
	    String ExpectedText = testdata.get("CustomViewButtonText");
	    String ActualText = display_options_page.getCustomViewButton().getText();
	    Assert.assertEquals(ActualText, ExpectedText);
	}

	@Then("^The Custom View Button Disappears$")
	public void the_Custom_Button_Disappears()  {
		newStep("The Custom View Button Should Disappear");
		try {
			//trying to access the element that should have disappeared
			display_options_page.getCustomViewButton();
		}catch(Exception e) {
			//if exception is thrown, i.e.,  the element is not found, then step is successful
			return;
		}
		//if the Custom View Button does not disappear throw an exception
		throw new RuntimeException("The Custom View Button did not Disappear!!!!");
	}
	
	
	
	
	@When("^User Clicks on Navigation Button$")
	public void user_Clicks_on_Navigation_Button()  {
		newStep("Click on Navigation Button");
		display_options_page.clickOnNavigationButton();
	}

	@Then("^The Naviagation Tabs Appear$")
	public void the_Naviagation_Tabs_Appear()  {
	    newStep("Fetching all the tabs that are visible");
	    ArrayList<String> TabsText = new ArrayList<String>();
	    for(MobileElement me : display_options_page.getTabs())
	    	TabsText.add(me.getText());
	    
	    newStep("Asserting all the TAB names in the Test Data are present in the fetched Tabs");	    
	    Assert.assertTrue(TabsText.contains(testdata.get("NaviagtionTab1Text")));
	    Assert.assertTrue(TabsText.contains(testdata.get("NaviagtionTab2Text")));
	    Assert.assertTrue(TabsText.contains(testdata.get("NaviagtionTab3Text")));
	}

	@Then("^The Naviagation Tabs Disappear$")
	public void the_Naviagation_Tabs_Disappear(){
	    newStep("The Navigation Tabs Disappear");
	    try {
	    	//trying to access the navigation tabs which should have disappeared
	    	display_options_page.getTabs();
	    }catch(Exception e) {
	    	//if exception is thrown, i.e.,  the element is not found, then step is successful
	    	return;
	    }
	    //if tab are still found then throw an exception
	    throw new RuntimeException("The Navigation Tabs were expected to DISAPPEAR but are still VISIBLE!!!");
	}

}
