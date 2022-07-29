@ExpandableListFeature
Feature: Expandable List Test
  Feature file to test the Expandable Lists

  @ExpandableList
  Scenario Outline: Expandable List Test
    Given User is on the Custom Adapter Page
    When User clicks on the <ListName> Text
    Then List items of <ListName> Should Appear
    When User clicks on the <ListName> Text
    Then List items of <ListName> Should Disappear

    Examples: 
      | ListName       |
      | "People Names" |
      | "Cat Names"    |
      | "Fish Names"   |