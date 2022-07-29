package pages;

import resources.BaseClass;

public class AppPage extends BaseClass{
	//This class contains various elements and functions related to the APP options.
	
	//Method for opening Activity
	public void goToActivity() {
		getElement(locators.get("Activity")).click();
	}
	
	//Method for opening Action Bar
	public void goToActionBar() {
		getElement(locators.get("ActionBar")).click();
	}
	
	//Method for opening Dispalay Options
	public void goToDisplayOptions() {
		getElement(locators.get("DisplayOptions")).click();
	}
	
	//Method for opening Custom Title
	public void goToCustomTitle() {
		getElement(locators.get("CustomTitle")).click();
	}	
	
	//Method for opening Notifications Option
	public void goToNotifications() {
		getElement(locators.get("Notification")).click();	 
	}

}
