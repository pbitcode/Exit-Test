package stepDefinitions;

import cucumber.api.java.en.*;
import io.appium.java_client.MobileElement;
import pages.HideShowAnimationPage;
import pages.HomePage;
import resources.BaseClass;

public class HideButtons extends BaseClass{
	
	HomePage home_page = new HomePage();
	HideShowAnimationPage hide_show_page = new HideShowAnimationPage();
	
	@Given("^User is on the Hide Buttons Page$")
	public void user_is_on_the_Hide_Buttons_Page() throws Throwable {
		newStep("Clicking on Animations");
		home_page.goToAnimationPage();
		
		newStep("Clicking on Hide-Show Animations");
		hide_show_page.goToHideShowAnimations();
	}

	@When("^The User clicks on a button with text (\\d+)$")
	public void the_User_clicks_on_a_button_with_text(int arg1) throws Throwable {
		newStep("Finding the Button with text '"+arg1+"' and clicking on it");
	    for(MobileElement element : hide_show_page.getHideButtons()){
	    	if(element.getText().equals(Integer.toString(arg1))) {
	    		element.click();
	    		return;
	    	}
	    }
	    //if the Button is not found then throw an exception
	    throw new RuntimeException("The Button with the text '"+arg1+"' was not found. Please Check if you have entered a valid value!!!");
	}

	@Then("^The Button with text (\\d+) gets hidden$")
	public void the_Button_with_text_gets_hidden(int arg1) throws Throwable {
		newStep("Verifying that the Button with text '"+arg1+"' is INVISIBLE.");
		for(MobileElement element : hide_show_page.getHideButtons()){
			
	    	if(element.getText().equals(Integer.toString(arg1))) {
	    		//if the Button is not found then throw an exception
	    		throw new RuntimeException("The Button with the text '"+arg1+"' is still visible.");
	    	}
	    }
	}
	
	
	
	
	@Given("^The Button with text (\\d+) is hidden$")
	public void the_Button_with_text_is_hidden(int arg1) throws Throwable {
		user_is_on_the_Hide_Buttons_Page();
		the_User_clicks_on_a_button_with_text(arg1);
		the_Button_with_text_gets_hidden(arg1);		
	}

	@When("^The User clicks on Show Buttons$")
	public void the_User_clicks_on_Show_Buttons() throws Throwable {
		newStep("Clicking on the Show Buttons! Button");
		hide_show_page.clickShowButtons();
	}

	@Then("^The Button with text (\\d+) is displayed$")
	public void the_Button_with_text_is_displayed(int arg1) throws Throwable {
		newStep("Verifying that the Button with text '"+arg1+"' is VISIBLE.");
		for(MobileElement element : hide_show_page.getHideButtons()){
				if(element.getText().equals(Integer.toString(arg1))) {
	    		return;
	    	}
	    }
	    //if the Button is not found then throw an exception
	    throw new RuntimeException("The Button with the text '"+arg1+"' was not found after clicking the Show Buttons");	    
	}

}
