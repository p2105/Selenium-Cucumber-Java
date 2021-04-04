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


//    For example, if you are using Maven and want to run a subset of scenarios tagged with @smoke:
//
//        mvn test -Dcucumber.filter.tags="@smoke"
//        Supported properties are:
//
//        cucumber.ansi-colors.disabled=  # true or false. default: false
//        cucumber.execution.dry-run=     # true or false. default: false
//        cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//        cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//        cucumber.execution.strict=      # true or false. default: true.
//        cucumber.execution.wip=         # true or false. default: false.
//        cucumber.features=              # command separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//        cucumber.filter.name=           # regex. example: .*Hello.*
//        cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//cucumber.glue=                  # comma separated package names. example: com.example.glue
//        cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//        cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//        cucumber.snippet-type=          # underscore or camelcase. default: underscore
