package humanforce.test;

import humanforce.test.utilities.CreateReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/failedrerun.txt"},
        plugin = {"rerun:target/failedrerun.txt", "pretty", "json:target/RerunCucumber.json"}
)
public class TestRunnerForFailed {
    @AfterClass
    public static void afterMethod() {
        CreateReport.make("target");
    }
}
