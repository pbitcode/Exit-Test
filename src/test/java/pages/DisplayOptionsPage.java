package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class DisplayOptionsPage extends BaseClass{
	//This class contains elements and various function related to the Display Options Page
	
	//Method to clikc on DISPLAY_SHOW_TITLE Button
	public void clickOnDISPLAY_SHOW_TITLE_Button() {
		getElement(locators.get("DISPLAY_SHOW_TITLEButton")).click();
	}
	
	//Method to get the Page Title as an Element
	public MobileElement getPageTitle() {
		return getElement(locators.get("Title"));
	}
	
	//Method to clikc on DISPLAY_SHOW_CUSTOM Button
	public void clickOnDISPLAY_SHOW_CUSTOMButton() {
		getElement(locators.get("DISPLAY_SHOW_CUSTOMButton")).click();
	}
	
	//Method returns the Custom View Button Element
	public MobileElement getCustomViewButton() {
		return getElement(locators.get("CustomViewButton"));
	}
	
	//Method to clikc on Navigation Button
	public void clickOnNavigationButton() {
		getElement(locators.get("NavigationButton")).click();
	}
	
	//Method returns the list of Tabs as Elements
	public List<MobileElement> getTabs(){
		return getElements(locators.get("GeneralTabsPath"));
	}

}
