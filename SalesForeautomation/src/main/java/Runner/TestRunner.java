package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
 @CucumberOptions(
		 features = "src/main/java/Featurefiles/Login.feature"
		 ,glue = {"Stepdefinition"}
		 )
		 
public class TestRunner {

}
