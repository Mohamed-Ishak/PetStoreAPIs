package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue = {"testSteps"},plugin = {"html:target/cucumber.html"})
@RunWith(Cucumber.class)
public class JUnitRunner {

}
