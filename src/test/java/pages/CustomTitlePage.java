package pages;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class CustomTitlePage extends BaseClass{
	//This class contains various elements and functions related to the Custom Title option.
	
	//Method for entering Title in the Left Title Text Field	
	public void enterLeftTitle(String title) {
		MobileElement element = getElement(locators.get("LeftTitleTextField"));
	    element.clear();
	    element.sendKeys(title);
	}
	
	//Method for clicking on Change Left Title Button
	public void clickOnChangeLeftTitleButton() {
		getElement(locators.get("ChangeLeftTitleButton")).click();;
	}
	
	//Method return the Left Title Element
	public MobileElement getLeftTitle() {
		return getElement(locators.get("LeftTitle"));
	}
	
	
	//Method for entering Title in the Right Title Text Field
	public void enterRightTitle(String title) {
		MobileElement element = getElement(locators.get("RightTitleTextField"));
	    element.clear();
	    element.sendKeys(title);
	}
	
	//Method for clicking on Change Right Title Button
	public void clickOnChangeRightTitleButton() {
		getElement(locators.get("ChangeRightTitleButton")).click();;
	}
	
	//Method return the Right Title Element
	public MobileElement getRightTitle() {
		return getElement(locators.get("RightTitle"));
	}

}
