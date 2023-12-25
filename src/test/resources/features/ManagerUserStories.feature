Feature: Humanforce Manager User Stories

  Scenario Outline: As an authenticated user <Manager user> MNGR01
    When I visit "https://qatestchallenge.humanforce.io/Account/LogOn?ReturnUrl=%2fHome"
    Then I should see the login page
    And  I login with the correct "<username>" in the username section
    And  I login with the correct "<password>" in the password section
    And  I log in
    Then I should see the dashboard
    Then Verify the greeting is visible Hello "<name>"
    And  I click on HF Academy at the bottom left of the page
    Then Verify that there is a pop up window
    And  I type "<Your Question>" in to the search box
    And  I click on How do I view or update my details article
    Then Verify that the engine opens up a new browser tab and close the current tab
    And  I navigate back to the Home Page("/Home")
    Then I log out
    Examples:
      | username | password         | name  | Your Question |
      | MNG01    | Q@T3chCh4lleng31 | Bruce | Personal      |

  Scenario: As an authenticated user <Manager> MNG01 save button should not be visible
    When I visit "https://qatestchallenge.humanforce.io/Account/EmployeeManagement"
    And I double click on my own employee profile (same Employee Code used to log in)
    And I should see the popup warning message advising I cannot edit my own profile
    Then Verify that the Save button is not visible