package humanforce.test;

import humanforce.test.utilities.CreateReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"rerun:target/failedrerun.txt", "pretty", "json:target/Cucumber.json"}
)
public class TestRunner {
    @AfterClass
    public static void afterMethod() {
        CreateReport.make("target");
    }
}
