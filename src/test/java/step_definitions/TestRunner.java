package step_definitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * The type Test runner.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/Features",
        glue={"step_definitions"},
        monochrome = true,
        plugin = {"pretty","html:target/Html/Reports.html"},
        tags = "@sanity1 or @sanity2"
)
public class TestRunner {

}


//    For example, if you are using Maven and want to run a subset of scenarios tagged with @smoke:
//
//        mvn test -Dcucumber.filter.tags="@smoke"
