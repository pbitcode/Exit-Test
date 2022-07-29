package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import pages.ExpandableListPage;
import pages.HomePage;
import resources.BaseClass;

public class ExpandableList extends BaseClass{
	
	HomePage home_page = new HomePage();
	ExpandableListPage expandable_list_page = new ExpandableListPage();
	
	List<MobileElement> elements;
	ArrayList<String> ListItems = new ArrayList<String>();
	String ListItems_raw;	// to store the List Items' Names from the Test Data File
	
	
	@Given("^User is on the Custom Adapter Page$")
	public void user_is_on_the_Custom_Adapter_Page() throws Throwable {
	    newStep("Clicking on Views");
	    home_page.goToViewsPage();
	    
	    newStep("Clicking on Expandable List");
	    expandable_list_page.goToExpandableList();
	    
	    newStep("Clicking on Custom Adapter");
	    expandable_list_page.goToCustomAdapter();
	}

	@When("^User clicks on the \"([^\"]*)\" Text$")
	public void user_clicks_on_the_Text(String arg1) throws Throwable {
		newStep("Clicking on '"+arg1+"'");
	    for(MobileElement me : expandable_list_page.getExpandableListItems())
	    	if(me.getText().equalsIgnoreCase(arg1)) {
	    		me.click();
	    		return;
	    	}
	    // if the passed List Name is not found, it throws an exception
	    throw new RuntimeException("The List with name '"+arg1+"' was not found. Please ensure that you have entered a valid value for the List Name");
	}

	@Then("^List items of \"([^\"]*)\" Should Appear$")
	public void list_items_of_Should_Appear(String arg1) throws Throwable {
		newStep("Fetching all the List Items Now Visible");
		//elements = getElements(locators.get("ExpandableListItems")); 
	    for(MobileElement me : expandable_list_page.getExpandableListItems())
	    	ListItems.add(me.getText());
		
	    newStep("Fetching the List Items for '"+arg1+"' from Test Data File");
	    String propertyName = arg1.replace(" ", "") + "ListItems";
	    ListItems_raw = testdata.get(propertyName);
	    
	    newStep("Validating that all the List Items for '"+ arg1 +"' are Visible");
	    for(String st : ListItems_raw.split(" "))
	    	Assert.assertTrue(ListItems.contains(st));	    
	    	
	}

	@Then("^List items of \"([^\"]*)\" Should Disappear$")
	public void list_items_of_Should_Disappear(String arg1) throws Throwable {
		newStep("Fetching all the List Items Now Visible");
		ListItems.clear();;
		//elements = getElements(locators.get("ExpandableListItems")); 
	    for(MobileElement me : expandable_list_page.getExpandableListItems())
	    	ListItems.add(me.getText());
	    
	    newStep("Validating that all the List Items for '"+ arg1 +"' are not Visible");
	    for(String st : ListItems_raw.split(" "))
	    	Assert.assertFalse(ListItems.contains(st));
	}

}
