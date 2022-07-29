package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import pages.AppPage;
import pages.HomePage;
import pages.NotificationsPage;
import resources.BaseClass;

public class Notifications extends BaseClass{
	
	HomePage home_page = new HomePage();
	AppPage app_page = new AppPage();
	NotificationsPage notifications_page = new NotificationsPage();
	
	List<MobileElement> elements;
	
	@Given("^The User is on the Notification Page$")
	public void the_User_is_on_the_Notifications_Page() throws Throwable {
		newStep("Clicking on App");
		home_page.goToAppPage();
	    
	    newStep("Clicking on Notification");
	    app_page.goToNotifications();   
	}

	@Given("^User Clicks on the Incoming Message Option$")
	public void user_Clicks_on_the_Incoming_Message_Option() throws Throwable {
		newStep("Clicking on IncomingMessage");
	    notifications_page.clickOnIncomingMessage();	 
	}

	@When("^User clicks on Show App Notification$")
	public void user_clicks_on_Show_App_Notification() throws Throwable {
		newStep("Clicking on Show App Notification Buttton");
	    notifications_page.clickOnShowAppNotification();
	}

	@Then("^A Notification from the app should be visible in the Notification Bar$")
	public void a_Notification_from_the_app_should_be_visible_in_the_Notification_Bar() throws Throwable {
	    newStep("Opening the Notifications");
	    verticalSwipeByPercentage(0.015, 0.75, 0.5);
	    
	    newStep("Fetching all the app Names in the Notifications");
	    elements = notifications_page.getNotifications();
	    
	    String AppName = testdata.get("AppName");
	    newStep("Checking if any of the App Notifications is from the App - " + AppName);
	    for(MobileElement me : elements)
	    	if(me.getText().toUpperCase().contains(AppName.toUpperCase())) {
	    		//waitToLoad(2500);
	    		//close notifications screen
	    		backbutton();
	    		return;
	    	}
	    //waitToLoad(2500);
	    //close notifications screen
	    backbutton();
//	    if no notification is found with the App Name throw an exception
	    throw new RuntimeException("There was no Notification found from the App - "+ AppName + " in the Notifications. Please Make Sure You have provided the correct App Name in the Test Data!");
	}
	
	
	
	
	
	
	@Given("^User Clicks on the NotifyWithText Option$")
	public void user_Clicks_on_the_NotifyWithText_Option() throws Throwable {
		newStep("Clicking on NotifyWithText");
		notifications_page.clickOnNotifyWithText();
	}

	@When("^User clicks on Show Short Notification Button$")
	public void user_clicks_on_Show_Short_Notification() throws Throwable {
		newStep("Clicking on Show Short Notification Buttton");
		notifications_page.clickOnShowShortNotification();
	}

	@Then("^A Text Notification should be visible on the Screen$")
	public void a_Text_Notification_from_the_app_should_be_visible_in_the_Notification_Bar() throws Throwable {
		newStep("Fetching the Actual Notification");
		String ActualNotification = notifications_page.getShortTextNotification().getText();
		
		newStep("Fetching the Expected Notification from Test Data");
		String ExpectedNotification = testdata.get("ShortNotification");
		
		newStep("Verifying that the Actual Notification with the Excpected Notification");
		Assert.assertEquals(ActualNotification, ExpectedNotification);
	    
	}

	@Then("^The Notification Should be become invisible in atmost five seconds$")
	public void the_Notification_Should_be_become_invisible_in_atmost_five_seconds() throws Throwable {	
		newStep("Wait for five seconds for the Notification to disapper");
		waitToLoad(5000);
		
		newStep("Verify that the Short Notification is not available");
		try {
			notifications_page.getShortTextNotification();
		}catch(Exception e) {
			pass();
			return;
		}
		//if the notification is still visible then throw an exception
		new RuntimeException("The Notification is still visible!!!");
	    
	}

}
