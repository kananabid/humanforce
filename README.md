# humanforcetestproject

# Test Automation Framework using Selenium, Java, Cucumber, JUnit, and Gradle

This is a test automation framework built using Selenium, Java, Cucumber, JUnit, and managed by Gradle.
It enables automated testing using behavior-driven development (BDD) principles.

## Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK 17 is used)
- Gradle
- WebDriver compatible with the browser(s) you intend to test

## Setup

1. **Clone the repo**
2. **Load Gradle build if you see the popup**
3. **Make sure to load the project and dependencies properly 🌚**

## Project Structure

- src/
    - main/
        - java/                          
        - resources
    - test/
        - java/                          
        - humanforce.test (Test files and step definitions)
        - resources   (Cucumber feature files)
- build.gradle (Gradle build script)
- README.md

## Running Tests

1. [ ] **IMPORTANT: Run this command on the terminal first: `chmod +x ./gradlew`**
2. [ ] **IMPORTANT: Execute tests using Gradle command: `.\gradlew runInitialTests`**
3. [ ] `DriverConfig` class **automatically** detects OS and initiates the driver
4. [ ] Tests are executed in headless mode

## Reporting

1. [ ] **Cucumber HTML reports is used for test reporting**
2. [ ] **Test report is in target/cucumber-html-reports/overview-failures.html**
3. [ ] (You can see other results in different tabs inside the html report)
4. [ ] **One user story inside `ManagerUserStories.feature` is deliberately created to fail in order to see the output in test report**
5. [ ] **Failed tests retry - Final report is in build/reports/tests/runFailedTests/index.html**

## Writing Tests

Tests are written in Cucumber feature files using Gherkin syntax located in `src/test/resources/features`.
Step definitions corresponding to these scenarios are written in Java located in `src/test/java/humanforce.test`.

- src/
    - test/
        - java/
        - humanforce.test/
            - driver (Contains `DriverConfig` class for Selenium WebDriver setup)
            - elements (Contains element locators and conditional enums)
            - stepDefinitions (Contains `Helper` and `UserStory` classes for step definitions)
            - utilities (Contains `CreateReport` class for test reporting)
- `TestRunner.java` (Main test runner class)
- `TestRunnerForFailed.java` (Runner class to **retry failed tests**)
- `README.md` (Project README)

## Notes

Comments are added to `Helper` class in order to explain the base methods used
Sleeps are added in between some steps in order to avoid unnecessary failures
(Ideally, they should not be present 🌚)

It's impossible to automate the User Story below as the userflow does not correspond to the scenario on the second step:
1. [ ]    Prerequisite:
2. [ ]    Download the provided CSV file
3. [ ]    Update the EmployeeCode, FirstName, LastName, ShortName, Email columns
4. [ ]    with your own EmployeeCode, Name and Email respectively
5. [ ] 
6. [ ] As an authenticated user <Admin> ADM01
7. [ ] When I visit <Test instance>/IntegrationsCentral
8. [ ] Then I click on the 'Add New' button
9. [ ] Then I click on 'File Import'
10. [ ] Then I enter a task name
11. [ ] Then I select the Data type of 'Employee Basic' from the drop-down box
12. [ ] Then I click 'Browse'
13. [ ] Then I select and upload the provided CSV file
14. [ ] Then I click 'Next' at the bottom of the page
15. [ ] Then I click 'Next' at the bottom of the page(Field Mapping Page)
16. [ ] Then I see the pop-up appears asking for one time import
17. [ ] Then I click 'Import Only'
18. [ ] Then I should see 'File import complete'
19. [ ] Then I click 'Got it'
20. [ ] 
21. [ ] Then I navigate to <Test instance>/EmployeeManagement
22. [ ] Verify there is an employee with my first name and last name
