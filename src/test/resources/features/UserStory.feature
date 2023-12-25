Feature: Humanforce User Stories

  Scenario: As an anonymous User I should see "7 benefits..." article
    When I visit "https://humanforce.com/"
    Then I should see the Humanforce public homepage
    And  Verify Humanforce logo is visible
    When I scroll to the bottom and select Time & Attendance
    Then I should see Helpful Resources, when I scroll to the bottom
    Then I select 7 benefits of workforce analytics for business
    Then I should see an article about this topic

  Scenario: As a non-logged in user I should see username and password fields
    When I visit "https://qatestchallenge.humanforce.io/Account/LogOn?ReturnUrl=%2fHome"
    Then I should see the login page "/Account/LogOn?ReturnUrl=%2f"
    Then Verify username and password fields are visible

