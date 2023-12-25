Feature: Humanforce Admin User Stories

  Background:
    Given I visit "https://qatestchallenge.humanforce.io/Account/LogOn?ReturnUrl=%2fHome"
    Then I should see the login page
    And  I login with the correct "ADM01" in the username section
    And  I login with the correct "Q@T3chCh4lleng31" in the password section
    And  I log in
    And  I close the welcome popup
    Then I visit "https://qatestchallenge.humanforce.io/Admin/Area"

  Scenario Outline: As an authenticated user create and delete Areas
    Given I save the items count
    And I press "Add new record" button
    And I enter all of the mandatory "<name>","<short name>" and "<export code>" data
    And I press 'Save' button
    Then I see one newly Area listed
    Then I create two more new Areas by repeating the previous steps with "<name1>", "<short name1>", "<export code1>" and "<name2>", "<short name2>", "<export code2>"
    Then I see three new Areas listed
    Then I click on "Edit" for one of the three new Areas
    Then I change the "Name" of the Area
    And I press 'Save' button
    And I click "Delete" for one of the three new Areas
    Then Verify out of the three Areas created, only the first two Areas area listed
    Then I press " UnDelete" button
    And I click Restore for the Area I deleted previously
    And I click Close to close the popup window
    Then Verify that all three newly created Areas are listed
    Examples:
      | name    | short name | export code | name1 | short name1 | export code1 | name2 | short name2 | export code2 |
      | Kanan   | Ken        | testcode    | Oliver| Oli         | testcode1    | Mikhail | Misha     | testcode2    |
