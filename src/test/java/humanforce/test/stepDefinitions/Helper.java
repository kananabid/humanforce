package humanforce.test.stepDefinitions;

import humanforce.test.driver.DriverConfig;
import humanforce.test.elements.enums.ExpectedConditionType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public abstract class Helper {

    // Initialize WebDriver using the DriverConfig class
    protected WebDriver driver = DriverConfig.getDriver();

    // Find a WebElement using the given locator
    protected WebElement ge(By locator) {
        return driver.findElement(locator);
    }

    // Perform an explicit wait for the given element based on the ExpectedConditionType and time
    protected void explicitWait(By element, ExpectedConditionType type, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (type) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case URL:
                wait.until(ExpectedConditions.urlToBe(element.toString()));
                break;
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
                break;
            default:
                throw new IllegalArgumentException("Unexpected ExpectedConditionType: " + type);
        }
    }

    // Overloaded method for performing an explicit wait for a WebElement
    protected void explicitWait(WebElement element, ExpectedConditionType type, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (type) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case URL:
                wait.until(ExpectedConditions.urlToBe(element.toString()));
                break;
            default:
                throw new IllegalArgumentException("Unexpected ExpectedConditionType: " + type);
        }
    }

    // Scroll to a specific element using JavaScript
    protected static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to accept cookies on the webpage (if present)
    public void acceptCookies() {
        try {
            // Wait for the cookie banner to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-cs-show-title='cookie-script']")));

            // Click on the 'Show Details' and 'Accept Cookies' buttons
            WebElement showDetailsButton = driver.findElement(By.cssSelector("span[data-cs-show-title='cookie-script']"));
            showDetailsButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookiescript_accept")));
            WebElement acceptCookiesBtn = driver.findElement(By.id("cookiescript_accept"));
            acceptCookiesBtn.click();
        } catch (Exception e) {
            // Handle exception if the cookie acceptance fails
            System.out.println("Cookie acceptance button not found or encountered an error: " + e.getMessage());
        }
    }

    // Find a WebElement based on its text content
    protected WebElement turnElementByText(String str1) {
        return driver.findElement(By.xpath("//*[text() = '" + str1 + "']"));
    }

    // Method to wait for a new tab and switch to it
    public void waitForNewTab(String mainWindowHandle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindowHandles = driver.getWindowHandles();
        String newTabHandle = allWindowHandles.stream()
                .filter(handle -> !handle.equals(mainWindowHandle))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New tab not found"));

        driver.switchTo().window(newTabHandle);
    }

    // Method to extract and return the second number from a string containing numbers
    public static int returnItemsNumber(String items) {
        String[] numbers = items.replaceAll("\\D", " ").trim().split("\\s+");
        if (numbers.length >= 2) {
            return Integer.parseInt(numbers[2]);
        } else {
            throw new IllegalArgumentException("No second number found in the input string");
        }
    }
}



