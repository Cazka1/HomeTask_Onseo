Feature: Feature
  As a user
  I want to test some site functional
  So that I can be sure that this functional works correctly


  Background: Background steps
    Given User closes cookies popup
    And User opens main menu
    And User opens 'Setting'
    When User opens time zone checkbox
    And User choose Timezone 'UTC +03:00'
    Then User clicks 'Apply' button


  @debug
  Scenario: Check correct time and date after change time zone

    Given User opens main menu
    And User opens 'Setting'
    When User opens time zone checkbox
    Then User sees current time zone
    And User clicks 'Apply' button
    Given User choose another day
    And User choose football event
    And User sees start time
    And User sees start date
    And User opens main menu
    And User opens 'Setting'
    And User opens time zone checkbox
    And User choose Timezone 'UTC +05:00'
    And User clicks 'Apply' button
    And User sees new start time
    And User sees new start date
    And User sees that new start time is correct
    And User sees that new start date is correct