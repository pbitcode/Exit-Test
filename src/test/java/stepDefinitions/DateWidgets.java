package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.DateWidgetsPage;
import pages.HomePage;
import resources.BaseClass;

public class DateWidgets extends BaseClass{
	
	HomePage home_page = new HomePage();
	DateWidgetsPage date_widgets_page = new DateWidgetsPage();
	
	
	@Given("^User is on the Date Widgets Dialog Screen$")
	public void user_is_on_the_Date_Widgets_Dialog_Screen() throws Throwable {
	    newStep("Clicking on Views");
	    home_page.goToViewsPage();
	    
	    newStep("Clicking on Date Widgets");
	    date_widgets_page.goToDateWidgets();
	    
	    newStep("Clicking on Dialog");
	    date_widgets_page.goToDialog();
	    
	}

	@When("^User clicks on Change The Date$")
	public void user_clicks_on_Change_The_Date() throws Throwable {
		newStep("Clicking on Change The Date");
		date_widgets_page.clickOnChangeTheDateButton();
	}
	
	@When("^User select the Year$")
	public void user_select_the_Year() throws Throwable {
	    newStep("Selecting the Year");
	    date_widgets_page.selectYear(testdata.get("Year"));
	}

	@When("^User selects the Month$")
	public void user_selects_the_Month() throws Throwable {
	    newStep("Selecting the Month");
	    date_widgets_page.selectMonth(testdata.get("Month"));
	}

	@When("^User select the Day$")
	public void user_select_the_Date() throws Throwable {
		newStep("Selecting the Day");		
		date_widgets_page.selectDay(testdata.get("Day"));
	}

	@When("^Clicks on OK$")
	public void clicks_on_OK() throws Throwable {
	    newStep("Clicking on OK Button");
	    date_widgets_page.clickOnOK();
	}

	@Then("^The Date should be changed as per the User Input$")
	public void the_Date_should_be_changed_as_per_the_User_Input() throws Throwable {
	    newStep("Fetching the Date on the Screen");
	    String actualDate = date_widgets_page.getDate().getText();
	    
	    newStep("Constructing Expected Date from the test data");
	    String expectedDate = testdata.get("MonthInNumber") + "-" + testdata.get("Day") + "-" + testdata.get("Year");
	    
	    newStep("Asserting that Actual Date contains Expected Date");
	    Assert.assertTrue(actualDate.contains(expectedDate));
	}	
	
	@When("^User clicks on Change The Time$")
	public void user_clicks_on_Change_The_Time() throws Throwable {
		newStep("Clicking on Change The Time");
		date_widgets_page.clickOnChangeTheTimeButton();
	}

	@When("^User select the Hours$")
	public void user_select_the_Hours() throws Throwable {
	    newStep("Selecting the Hour");
	    date_widgets_page.selectHour(testdata.get("Hour"));	    
	}

	@When("^User selects the Minutes$")
	public void user_selects_the_Minutes() throws Throwable {
		newStep("Selecting the Minutes");		
		date_widgets_page.selectMinutes(testdata.get("Minutes"));
	}

	@When("^User select AM or PM$")
	public void user_select_AM_or_PM() throws Throwable {
		newStep("Selecting AM/PM");	
		date_widgets_page.selectAMPMValue(testdata.get("AMPMValue"));
	}

	@Then("^The Time should be changed as per the User Input$")
	public void the_Tme_should_be_changed_as_per_the_User_Input() throws Throwable {
		newStep("Fetching the Time on the Screen");
	    String actualTime = date_widgets_page.getDate().getText();	
	    actualTime = actualTime.substring(actualTime.length() - 5, actualTime.length());
	    
	    newStep("Constructing Expected Time from the test data");
	    String ExpectedTime = "";
	    //Adding Hours to the ExpectedTime
	    if(testdata.get("AMPMValue").equalsIgnoreCase("AM")) {
	    	if(testdata.get("Hour").equalsIgnoreCase("12"))
	    		ExpectedTime = "00";
	    	else {
	    		ExpectedTime = testdata.get("Hour");
	    	}
	    }else {
	    	if(testdata.get("Hour").equalsIgnoreCase("12"))
	    		ExpectedTime = "12";
	    	else {
	    		int num = Integer.parseInt(testdata.get("Hour")) + 12;
	    		ExpectedTime = Integer.toString(num);
	    	}
	    }
	    //Adding Minutes to the ExpectedTime
	    ExpectedTime += ":" + testdata.get("Minutes");
	    
	    newStep("Asserting that Actual Time equals Expected Time");
	    Assert.assertTrue(actualTime.equals(ExpectedTime));
	}

}
