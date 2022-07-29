package pages;

import java.util.ArrayList;
import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class DateWidgetsPage extends BaseClass{
	//This class contains various elements and functions related to the DateWidgets option.
	
	//Method to get to the Date Widgets Screen
	public void goToDateWidgets() {
		getElement(locators.get("DateWidgets")).click();
	}
	
	//Method to click on Dialog Option
	public void goToDialog() {
		getElement(locators.get("Dialog")).click();
	}
	
	//Method to select the Change the Date Button
	public void clickOnChangeTheDateButton() {
		getElement(locators.get("ChangeDateButton")).click();
	}
	
	//Method takes the Year as argument and selects it on the Date Select Widget
	public void selectYear(String desired_year) {
		getElement(locators.get("YearHeader")).click();
		
		if(Integer.parseInt(desired_year)>2100 || Integer.parseInt(desired_year)<1900)
			throw new RuntimeException("The Year Value is out of range. Please enter a value between 1900 and 2100!!!");
		
		while(true) {
		    for(MobileElement me : getElements(locators.get("Years"))) {
		    	if(me.getText().equals(desired_year)) {
		    		me.click();
		    		return;
		    	}
		    }
		    
		    String current_top_year = getElement(locators.get("Years")).getText();
		    if(Integer.parseInt(current_top_year)>Integer.parseInt(desired_year))
		    	verticalSwipeByPercentage(0.5, 0.95, 0.5);
		    else
		    	verticalSwipeByPercentage(0.5, 0.05, 0.5);
		}
	}
	
	//Method takes the Month as argument and selects it on the Date Select Widget
	public void selectMonth(String desired_month) {
		MobileElement me = getElement(locators.get("Dates"));
	    String[] strings = {"January", "February", "March", "April", "May", "June",
	    		"July", "August", "September", "October", "November", "December"};
	    ArrayList<String> Months_Name = new ArrayList<String>();
	    for(String st : strings)
	    	Months_Name.add(st.toUpperCase());
	    
	    desired_month = desired_month.toUpperCase();
	    String current = me.getAttribute("content-desc").toUpperCase();
	    String current_month = current.substring(3, current.length() - 5);
	    
	    if(!Months_Name.contains(testdata.get("Month").toUpperCase()))
	    	throw new RuntimeException("The Month - '"+desired_month+"' is INVALID. PLEASE ENTER A VALID MONTH VALUE");
	    int desired_Month_index = Months_Name.indexOf(desired_month);
	    int current_Month_index = Months_Name.indexOf(current_month);
	    
	    if(desired_Month_index < current_Month_index) {
		    while(!me.getAttribute("content-desc").toUpperCase().contains(testdata.get("Month").toUpperCase())) {
		    	getElement(locators.get("PreviousMonthButton")).click();
		    	me = getElement(locators.get("Dates"));
		    }
	    }else if(desired_Month_index > current_Month_index) {
		    while(!me.getAttribute("content-desc").toUpperCase().contains(testdata.get("Month").toUpperCase()) ) {
		    	getElement(locators.get("NextMonthButton")).click();
		    	me = getElement(locators.get("Dates"));
		    }
	    }
	}
	
	//Method takes the Day as argument and selects it on the Date Select Widget
	public void selectDay(String desired_day) {
	    String day;
	    for(MobileElement me : getElements(locators.get("Dates"))) {
	    	day = me.getAttribute("content-desc").substring(0, 2);
	    	if(day.equals(testdata.get("Day"))) {
	    		me.click();
	    		return;
	    	}
	    }
	    //if day not found throw an exception
	    throw new RuntimeException("The Day - "+ testdata.get("Day") + " was not found. Please make sure you have passed the correct Day Value");
	}
	
	//Method clicks on OK
	public void clickOnOK() {
		getElement(locators.get("OKButton")).click();
	}
	
	//Method to get the Date displayed on the Screen, it also contains the time
	public MobileElement getDate() {
		return getElement(locators.get("DateDisplay"));
	}
	
	//Method to select the Change the Time Button
	public void clickOnChangeTheTimeButton() {
		getElement(locators.get("ChangeTimeButton")).click();
	}
	
	//Method takes the Hour as argument and selects it on the Time Select Widget
	public void selectHour(String desired_hour) {
	    for(MobileElement me : getElements(locators.get("RadialTimePicker")))
	    	if(me.getAttribute("content-desc").equals(desired_hour)) {
	    		me.click();
	    		return;
	    	}
	    throw new RuntimeException("The option with Hour - "+ desired_hour +" is not available. Please check that you have entered a VALID INPUT!!!");
	}
	
	//Method takes the Minutes as argument and selects it on the Time Select Widget
	public void selectMinutes(String minutes) {
	    for(MobileElement me : getElements(locators.get("RadialTimePicker")))
	    	if(me.getAttribute("content-desc").equals(testdata.get("Minutes"))) {
	    		me.click();
	    		return;
	    	}
	    throw new RuntimeException("The option with Minutes - "+ minutes +" is not available. Please check that you have entered a VALID INPUT!!!");	
	}
	
	////Method takes the AM/PM as argument and selects it on the Time Select Widget
	public void selectAMPMValue(String value) {
	    for(MobileElement me : getElements(locators.get("AMPMButtons")))
	    	if(me.getText().equalsIgnoreCase(value)) {
	    		me.click();
	    		return;
	    	}
	    throw new RuntimeException("The AM/PM Value - '"+ value + "' is not available. Please make sure you have passed a VALID Value");
	
	}
	
	
}
