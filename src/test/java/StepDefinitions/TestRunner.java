package StepDefinitions;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
glue= {"StepDefinitions"},
//tags= {"@scenario1 or @scenario1"},
monochrome = true,
plugin = { "pretty",  "json:target/JSONReports/cucumber.json"})
//"pretty", "html:target/reports",
//"pretty", "json:target/JSONReports/cucumber.json",
//"pretty",  "junit:target/JUnitReports/cucumber.xml"
public class TestRunner {

}