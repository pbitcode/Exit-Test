@TextFeatures
Feature: Verify various functionalities of Text
  Feature file to test Text Features

  @LogTextBox
  Scenario Outline: Log Text Box Test
  Text should be logged on the screen whenever user clicks Add Button
    Given User is on LogTextBox Page
    When User clicks the Add Button <num> times
    Then The respective text should be logged on the screen for <num> times

    Examples: 
      | num |
      |   3 |