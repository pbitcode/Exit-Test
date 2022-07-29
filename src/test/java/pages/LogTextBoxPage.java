package pages;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class LogTextBoxPage extends BaseClass{
	//This class contains Elements and methods related to the Log Text Box Page
	
	//Method clicks on the LogTextBox Option
	public void clickOnLogTextBox() {
		getElement(locators.get("LogTextBox")).click();
	}
	
	//Method clicks on 'Add Log Text' Button
	public void clickOnAddLogTextButton() {
		getElement(locators.get("LogTextAddButton")).click();
	}
	
	//Method returns the Display Screen ELement of the Log Text Page
	public MobileElement getLogTextDisplayScreen() {
		return getElement(locators.get("LogTextDisplayScreen"));
	}

}
