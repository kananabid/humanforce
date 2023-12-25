package humanforce.test.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.UUID;

public class DriverConfig {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Before
    public void beforeScenario() {
        WebDriver driver = createDriver();
        driverThreadLocal.set(driver);
    }

    @After
    public void afterScenario(Scenario scenario) {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                if (scenario.isFailed()) {
                    // Take screenshot and attach it to the scenario
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
                    scenario.attach(fileContent, "image/png", UUID.randomUUID().toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
                System.out.println("afterScenario -> WebDriver quit.");
            }
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.setCapability("acceptInsecureCerts", true);

        String os = System.getProperty("os.name").toLowerCase();
        String driverPath = "";

        if (os.contains("win")) {
            driverPath = "src/main/resources/win/chromedriver.exe";
        } else if (os.contains("mac")) {
            driverPath = "src/main/resources/mac/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver(chromeOptions);
    }
}
