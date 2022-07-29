@DisplayOptions
Feature: Display Options Feature
  Feature file to test various Display Options

  @ShowHideTitle
  Scenario: Hide Show Title on the Screen
    Given User is on Display Options Page
    When User Clicks on DISPLAY_SHOW_TITLE Button
    Then The Title Disappears
    When User Clicks on DISPLAY_SHOW_TITLE Button
    Then The Title Reappears

  @ShowHideCustomViewButton
  Scenario: Hide Show Title on the Screen
    Given User is on Display Options Page
    When User Clicks on DISPLAY_SHOW_CUSTOM Button
    Then The Custom View Button Appears
    When User Clicks on DISPLAY_SHOW_CUSTOM Button
    Then The Custom View Button Disappears
    
	@NavigationTabs
  Scenario: Navigation Tabs on the Screen
    Given User is on Display Options Page
    When User Clicks on Navigation Button
    Then The Naviagation Tabs Appear
    When User Clicks on Navigation Button
    Then The Naviagation Tabs Disappear