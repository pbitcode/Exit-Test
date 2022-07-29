@DateWidgets
Feature: Date Widgets Test
  Feature file to test setting the Date and Time

  @ChangeDateTest
  Scenario: Date Change Test
    Given User is on the Date Widgets Dialog Screen
    When User clicks on Change The Date
    And User select the Year
    And User selects the Month
    And User select the Day
    And Clicks on OK
    Then The Date should be changed as per the User Input
    
	@ChangeTimeTest
  Scenario: Time Change Test
    Given User is on the Date Widgets Dialog Screen
    When User clicks on Change The Time
    And User select the Hours
    And User selects the Minutes
    And User select AM or PM
    And Clicks on OK
    Then The Time should be changed as per the User Input 