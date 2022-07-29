@ChangeTitles
Feature: Change Title of the Page
  Feature file to test changing the Right and Left Title of the Page
  
  @ChangeLeftTitle
  Scenario Outline: Change Left Title of the Page
  Given User is on Custom Title Page
  When User enter the Title as <Title> in the Left Title Text Box
  And Clicks on the Change Left Title Button
  Then The entered <Title> should be displayed as the Left Title
  
  Examples:
  | Title                      |
  | "Left Title for Test Case" |
    
  
  @ChangeRightTitle
  Scenario Outline: Change Right Title of the Page
    Given User is on Custom Title Page
    When User enter the Title as <Title> in the Right Title Text Box
    And Clicks on the Change Right Title Button
    Then The entered <Title> should be displayed as the Right Title

    Examples: 
      | Title                       |
      | "Right Title for Test Case" |