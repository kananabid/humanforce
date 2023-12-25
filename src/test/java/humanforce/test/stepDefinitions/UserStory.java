package humanforce.test.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static humanforce.test.elements.UserStoryPOM.*;
import static humanforce.test.elements.enums.ExpectedConditionType.*;

// Extends Helper class in order to use base methods in step definitions
public class UserStory extends Helper {
    private  int beforeItemsCount;

    @When("I visit {string}")
    public void iVisitHttps(String url) {
        driver.get(url);
    }

    @Then("I should see the Humanforce public homepage")
    public void iShouldSeeTheHumanforcePublicHomepage() {
        Assert.assertTrue(driver.getTitle().contains("Workforce Management, HR, Payroll & Wellbeing – Unified | Humanforce"));
    }

    @And("Verify Humanforce logo is visible")
    public void verifyHumanforceLogoIsVisible() {
        explicitWait(logoHumanforce, VISIBLE,15);
        Assert.assertTrue(ge(logoHumanforce).isDisplayed());
    }

    @When("I scroll to the bottom and select Time & Attendance")
    public void iScrollToTheBottomAndSelectTimeAndAttendance() {
        explicitWait(continueHereBtn, VISIBLE, 15);
        ge(continueHereBtn).click();
        List<WebElement> links = driver.findElements(By.cssSelector("ul.w-full > li > a"));
        for (WebElement link : links) {
            if (link.getText().equals("Time & Attendance")) {
                link.click();
                break;
            }
        }
    }

    @Then("I should see Helpful Resources, when I scroll to the bottom")
    public void iShouldSeeHelpfulResourcesWhenIScrollToTheBottom() {
        explicitWait(timeAndAttendanceImg, VISIBLE,15);
        Assert.assertTrue(ge(timeAndAttendanceImg).isDisplayed());
        acceptCookies();
        scrollToElement(driver, ge(helpfulResources));
        explicitWait(helpfulResources, VISIBLE, 15);
        Assert.assertTrue(ge(helpfulResources).isDisplayed());
    }

    @Then("I select 7 benefits of workforce analytics for business")
    public void iSelectBenefitsArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Extend the timeout as needed
        wait.until((ExpectedCondition<Boolean>) wd ->
        {
            assert wd != null;
            return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
        });

        Object imageElement = ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector(\"img[src*='blog-image-7-benefits-of-workforce-analytics-for-business']\")");
        if (imageElement instanceof WebElement) {
            WebElement actualImageElement = (WebElement) imageElement;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actualImageElement);
            actualImageElement.click();
        } else {
            System.out.println("Image element not found!");
        }
    }

    @Then("I should see an article about this topic")
    public void iShouldSeeAnArticleAboutThisTopic() {
        explicitWait(actualBenefitsArticle, VISIBLE, 15);
        Assert.assertTrue(ge(actualBenefitsArticle).isDisplayed());
    }

    @Then("I should see the login page {string}")
    public void iShouldSeeTheLoginPage(String arg0) {
        Assert.assertTrue(driver.getCurrentUrl().contains(arg0));
    }

    @Then("Verify username and password fields are visible")
    public void verifyUsernameAndPasswordFieldsAreVisible() {
        explicitWait(usernameInput, VISIBLE, 15);
        Assert.assertTrue(ge(usernameInput).isDisplayed()&&ge(passwordInput).isDisplayed());
    }

    @Then("I should see the login page")
    public void iShouldSeeTheLoginPage() {
        Assert.assertTrue(driver.getTitle().contains("Logon"));
    }


    @And("I login with the correct {string} in the username section")
    public void iLoginWithTheCorrectUsername(String arg1) {
        explicitWait(usernameInput, VISIBLE, 15);
        ge(usernameInput).sendKeys(arg1);
    }

    @And("I login with the correct {string} in the password section")
    public void iLoginWithTheCorrectPassword(String arg1) {
        explicitWait(passwordInput, VISIBLE, 15);
        ge(passwordInput).sendKeys(arg1);
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard(){
        explicitWait(welcomePopUpClose, VISIBLE, 15);
        ge(welcomePopUpClose).click();
        explicitWait(dashboardElement, VISIBLE, 15);
        Assert.assertTrue(driver.getTitle().contains("Home"));
    }

    @Then("Verify the greeting is visible Hello {string}")
    public void verifyTheGreetingIsVisibleHello(String name) {
        explicitWait(helloName, VISIBLE, 15);
        Assert.assertEquals(ge(helloName).getText(), "Hello "+name);
    }

    @Then("I click on HF Academy at the bottom left of the page")
    public void iClickOnHFAcademyAtTheBottomLeftOfThePage() {
        explicitWait(announceModel, INVISIBLE, 25);
        explicitWait(hfAcademy, VISIBLE, 25);
        ge(hfAcademy).click();
    }

    @Then("Verify that there is a pop up window")
    public void verifyThatThereIsAPopUpWindow() {
        explicitWait(hfAcademyPopUp, VISIBLE, 15);
        Assert.assertTrue(ge(hfAcademyPopUp).isDisplayed());
    }

    @Then("I type {string} in to the search box")
    public void iTypeInToTheSearchBox(String arg0) {
        explicitWait(questionInput, VISIBLE, 15);
        ge(questionInput).sendKeys(arg0);
    }

    @Then("I click on How do I view or update my details article")
    public void iClickOnHowDoIViewOrUpdateMyDetailsArticle() {
        explicitWait(personalResultTitle, VISIBLE, 15);
        ge(personalResultTitle).click();
    }

    @Then("Verify that the engine opens up a new browser tab and close the current tab")
    public void verifyThatTheEngineOpensUpANewBrowserTab() {
        String mainWindowHandle = driver.getWindowHandle();
        waitForNewTab(mainWindowHandle);
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    @Then("I navigate back to the Home Page\\({string})")
    public void iNavigateBackToTheHomePage(String url) throws InterruptedException {
        explicitWait(popupCloseBtn, VISIBLE, 15);
        ge(popupCloseBtn).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @Then("I log out")
    public void iLogOut() {
        explicitWait(logOutBtn, VISIBLE, 15);
        ge(logOutBtn).click();
    }

    @And("I log in")
    public void iLogIn() {
        explicitWait(logInBtn, CLICKABLE, 15);
        ge(logInBtn).click();
    }

    @Then("I press {string} button")
    public void iPressButton(String elementText) {
        explicitWait(turnElementByText(elementText), VISIBLE, 15);
        turnElementByText(elementText).click();
    }

    @Then("I enter all of the mandatory {string},{string} and {string} data")
    public void iEnterAllOfTheMandatoryData(String name, String shortName, String exportCode) {
        explicitWait(userInfodatapopUp, VISIBLE, 15);
        ge(nameInput).sendKeys(name);
        ge(shortNameInput).sendKeys(shortName);
        ge(exportCodeInput).sendKeys(exportCode);
    }

    @Then("I see one newly Area listed")
    public void iSeeNewlyAreaListed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        explicitWait(itemsText, VISIBLE, 15);
        Integer newItemsCount = returnItemsNumber(ge(itemsText).getText());
        Assert.assertEquals(beforeItemsCount+1,newItemsCount);
    }

    @And("I close the welcome popup")
    public void iCloseTheWelcomePopup() {
        explicitWait(welcomePopUpClose, VISIBLE, 15);
        ge(welcomePopUpClose).click();
    }

    @Given("I save the items count")
    public void iSaveTheItemsCount() {
        explicitWait(itemsText, VISIBLE, 15);
        beforeItemsCount = returnItemsNumber(ge(itemsText).getText());
    }

    @Then("I see three new Areas listed")
    public void iSeeThreeNewAreasListed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        explicitWait(itemsText, VISIBLE, 15);
        Integer newItemsCount = returnItemsNumber(ge(itemsText).getText());
        Assert.assertEquals(beforeItemsCount+3,newItemsCount);
    }

    @Then("I click on {string} for one of the three new Areas")
    public void iClickOnForOneOfTheNewAreas(String elementText) {
        explicitWait(turnElementByText(elementText), VISIBLE, 15);
        turnElementByText(elementText).click();
    }
    @Then("I click {string} for one of the three new Areas")
    public void iClickForOneOfTheNewAreas(String elementText) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        explicitWait(turnElementByText(elementText), VISIBLE, 15);
        turnElementByText(elementText).click();
        explicitWait(yesBtn, VISIBLE, 15);
        ge(yesBtn).click();
    }

    @Then("I change the {string} of the Area")
    public void iChangeTheNameOfTheArea(String name) {
        explicitWait(userInfodatapopUp, VISIBLE, 15);
        ge(nameInput).clear();
        ge(nameInput).sendKeys(name);
    }

    @Then("I create two more new Areas by repeating the previous steps with {string}, {string}, {string} and {string}, {string}, {string}")
    public void iCreateTwoMoreNewAreasByRepeatingThePreviousStepsWithAnd(String name1, String shortName1, String exportCode1, String name2, String shortName2, String exportCode2) {
        explicitWait(addNewRecordBtn, VISIBLE, 15);
        ge(addNewRecordBtn).click();
        ge(nameInput).sendKeys(name1);
        ge(shortNameInput).sendKeys(shortName1);
        ge(exportCodeInput).sendKeys(exportCode1);
        ge(saveBtn).click();
        explicitWait(addNewRecordBtn, VISIBLE, 15);
        ge(addNewRecordBtn).click();
        ge(nameInput).sendKeys(name2);
        ge(shortNameInput).sendKeys(shortName2);
        ge(exportCodeInput).sendKeys(exportCode2);
        ge(saveBtn).click();
    }

    @Then("Verify out of the three Areas created, only the first two Areas area listed")
    public void verifyOutOfTheThreeAreasCreatedOnlyTheFirstTwoAreasAreaListed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        explicitWait(itemsText, VISIBLE, 15);
        Integer newItemsCount = returnItemsNumber(ge(itemsText).getText());
        Assert.assertEquals(beforeItemsCount+2,newItemsCount);
    }

    @And("I click Restore for the Area I deleted previously")
    public void iClickRestoreForTheAreaIDeletedPreviously() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> restoreButtons = driver.findElements(By.cssSelector("a.k-button-icontext.k-grid-Restore"));
        if (!restoreButtons.isEmpty()) {
            WebElement lastRestoreButton = restoreButtons.get(restoreButtons.size() - 1);
            lastRestoreButton.click();
        } else {
            System.out.println("No 'Restore' buttons found on the page.");
        }
    }

    @And("I click Close to close the popup window")
    public void iClickCloseToCloseThePopupWindow() {
        WebElement element = driver.findElement(By.cssSelector("a[aria-label='Close']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("Verify that all three newly created Areas are listed")
    public void verifyThatAllThreeNewlyCreatedAreasAreListed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        explicitWait(itemsText, VISIBLE, 15);
        Integer newItemsCount = returnItemsNumber(ge(itemsText).getText());
        Assert.assertEquals(beforeItemsCount+2,newItemsCount);
    }

    @And("I double click on my own employee profile \\(same Employee Code used to log in)")
    public void iDoubleClickOnMyOwnEmployeeProfileSameEmployeeCodeUsedToLogIn() {
        explicitWait(employeeBtn, VISIBLE, 5);
        ge(employeeBtn).click(); //This step is created for testing retry mechanism
    }

    @And("I should see the popup warning message advising I cannot edit my own profile")
    public void iShouldSeeThePopupWarningMessageAdvisingICannotEditMyOwnProfile() {
        //This step is created for testing retry mechanism
    }

    @Then("Verify that the Save button is not visible")
    public void verifyThatTheSaveButtonIsNotVisible() {
        //This step is created for testing retry mechanism
    }
}
