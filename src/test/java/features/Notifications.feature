@NotificationsFeatureTest
Feature: Various Notifications Test
  Feature file to test Notifications functionalities

  @IncomingMesageTest
  Scenario: Incoming Mesage Test
    Given The User is on the Notification Page
    And User Clicks on the Incoming Message Option
    When User clicks on Show App Notification
    Then A Notification from the app should be visible in the Notification Bar
    
	@NotifyWithTextTest
  Scenario: Notify With Text Test
    Given The User is on the Notification Page
    And User Clicks on the NotifyWithText Option
    When User clicks on Show Short Notification Button
    Then A Text Notification should be visible on the Screen
    And The Notification Should be become invisible in atmost five seconds