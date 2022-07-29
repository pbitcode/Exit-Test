package pages;

import resources.BaseClass;

public class HomePage extends BaseClass{
	//This class contains Elements and functions related to the Home Page of the App
	
	//Method clicks on App Option
	public void goToAppPage() {
		getElement(locators.get("App")).click();
	}
	
	//Method clicks on Animation Option	
	public void goToAnimationPage() {
		getElement(locators.get("Animation")).click();;
	}
	
	//Method clicks on Text Option
	public void goToTextPage() {
		getElement(locators.get("Text")).click();
	}
	
	//Method clicks on Views Option
	public void goToViewsPage() {
		getElement(locators.get("Views")).click();
	}

}
