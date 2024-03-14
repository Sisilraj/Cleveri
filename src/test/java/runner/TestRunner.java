package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/features",
		glue = {"stepDefinitions", "hooks"},
		plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"},
<<<<<<< HEAD
//		tags = "@applicants", // @login  @dashboard  @applicants  @jobs  @organization  @client
=======
		tags = "@applicants", // @login  @dashboard  @applicants  @jobs  @organization  @client
>>>>>>> 6d35ecf6d86792a07b4ba399ca8d0299b015652a
		publish = true
		
	)

public class TestRunner {

}
