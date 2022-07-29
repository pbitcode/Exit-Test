package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class ExpandableListPage extends BaseClass{
	//This class contains elements and functions related to the Expandable List Page
	
	//Method to click on the Expandable List Option
	public void goToExpandableList() {
		getElement(locators.get("ExpandableList")).click();
	}
	
	//Method to click on Custom Adapter Option
	public void goToCustomAdapter() {
		getElement(locators.get("CustomAdapter")).click();
	}
	
	//Method return the List of List Items present on the Screen
	public List<MobileElement> getExpandableListItems(){
		return getElements(locators.get("ExpandableListItems")); 
	}

}
