Feature: TestLogin
  Scenario: Notification Settings
    Given user on Notification settings page
    When user clicked Notification settings
    Then Notification settings should be displayed
    When App notifications is clicked
    Then App notifications should be displayed
    When Notification history is clicked
    Then Notification history should be displayed
    When Conversations is clicked
    Then Conversations should be displayed
    When Bubbles is clicked
    Then Bubbles should be displayed

