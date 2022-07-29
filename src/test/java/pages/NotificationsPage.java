package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import resources.BaseClass;

public class NotificationsPage extends BaseClass{
	//This Class contains ELements and methods related to the Notifications Page
	
	//Method to CLick on IncomingMessage Option
	public void clickOnIncomingMessage() {
		getElement(locators.get("IncomingMessage")).click();
	}
	
	//Method to CLick on 'Show App Notification' Button
	public void clickOnShowAppNotification() {
		getElement(locators.get("ShowAppNotification")).click();
	}
	
	//Method return the list of MobileElement of App Notifications
	public List<MobileElement> getNotifications() {
		return getElements(locators.get("NotificationsAppName"));
	}
	
	//Method to CLick on 'Notify With Text' Option
	public void clickOnNotifyWithText() {
		getElement(locators.get("NotifyWithText")).click();
	}
	
	//Method to CLick on 'Show Short Notification' Button
	public void clickOnShowShortNotification() {
		getElement(locators.get("ShowShortNotificationButton")).click();
	}
	
	
	//Method return the object of the Short Notification
	public MobileElement getShortTextNotification() {
		return getElement(locators.get("ShortTextNotification"));
	}

}
