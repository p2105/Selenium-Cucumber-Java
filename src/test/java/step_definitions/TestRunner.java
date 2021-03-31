package step_definitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue={"step_definitions"},monochrome = true,
        plugin = {"pretty","html:target/Html/Reports.html"},
        tags = "@sanity"
)
public class TestRunner {

}
