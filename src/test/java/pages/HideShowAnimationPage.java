package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class HideShowAnimationPage extends BaseClass{
	//This class contains Elements and functions related to the Hide Show Animation Page
	
	//Method clicks on the Hide Show Animation Option
	public void goToHideShowAnimations() {
		getElement(locators.get("HideShowAnimations")).click();
	}
	
	//Method return the List of Buttons present
	public List<MobileElement> getHideButtons() {
		return getElements(locators.get("HideButtonsGeneralPath"));
	}
	
	//Method clicks on Show Buttons Button
	public void clickShowButtons() {
		getElement(locators.get("ShowButtons")).click();
	}

}
