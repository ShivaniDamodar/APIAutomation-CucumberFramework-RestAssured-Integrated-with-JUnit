package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features/usersAPI.feature", glue= {"stepDefinations"})
public class TestRunner {
	
	
	

}
