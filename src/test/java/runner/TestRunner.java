package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/features",
		glue = {"stepDefinitions", "hooks"},
		plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"},
//		tags = "@applicants", // @login  @dashboard  @applicants  @jobs  @organization  @client
		publish = true
		
	)

public class TestRunner {

}