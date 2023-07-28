package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/CSRFToken/CsrfToken.feature",glue = {"StepDefinations"},
        monochrome = true,
        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class ApiTestRunner {
}