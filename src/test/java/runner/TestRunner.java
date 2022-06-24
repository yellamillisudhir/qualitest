package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/test.feature", glue = {
		"cucumber.test.steps" }, dryRun = false, strict = true)
public class TestRunner {

}