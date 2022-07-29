@HideShowButtons
Feature: Hide Show Buttons Feature
  Feature file to test Hide and Show functionalities
  @HideButtons
  Scenario Outline: Hide Button Scenario
    Given User is on the Hide Buttons Page
    When The User clicks on a button with text <ButtonText>
    Then The Button with text <ButtonText> gets hidden

    Examples: 
      | ButtonText |
      |          0 |
      |          1 |
      ##The valid values for ButtonText are 0, 1, 2 and 3 ONLY. For any other values, an exception will be thrown.

  @ShowButtons
  Scenario Outline: Show Button Scenario
    Given The Button with text <ButtonText> is hidden
    When The User clicks on Show Buttons
    Then The Button with text <ButtonText> is displayed

    Examples: 
      | ButtonText |
      |          0 |
      |          1 |
      ##The valid values for ButtonText are 0, 1, 2 and 3 ONLY. For any other values, an exception will be thrown.