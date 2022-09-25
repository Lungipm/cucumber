package StepDefinations;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = {"StepDefinations"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reports/cucumberReport.html"})
public class testRunner {




}
