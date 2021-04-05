# BDD Cucumber Framework using Java and Selenium

This is a Cucumber BDD framework developed using Java language and Page Object Model Design pattern.

## Installation

Use the git cli to clone.

```git
git clone https://github.com/p2105/Selenium-Cucumber-Java/tree/new_log_functionality
```

## Configuration

```properties
- This is placed at location src/configs/Configuration.properties
- Below are the usages for it:
  - driverPath=src/main/resources/browser_driver
      The directory where all the drivers are present, currently all the drivers are within the framework folder.
  - browser=chrome
      The browser to be used for the execution. Currently the framework supports Chrome, Firefox and IE.
  - pathToFirefoxExecutable=C:/Program Files (x86)/Mozilla Firefox/firefox.exe
      This is a mandatory setting if you use firefox browser. This is the location of the Firefox executable on your machine.
  - maxWait=20
      This is the max number of seconds the script will wait for an object to appear on screen, can be configured accordingly.
  - logLevel=INFO
      This the log level to be used. Set it to DEBUG to print all the `Log.debug()` messages or to INFO to print the `Log.info()` messages. Supported Log Levels DEBUG and INFO
  - qaUrl or devUrl or prodUrl = Application Url
      These are used to specify the different environments for your application. You can pass the environment variables for e.g. `env=QA` for QA environment as CLI argument
```

## Usage
- Start by defining your Page Objects in the package "src/main/java/pagefactory"
- You can also create reusable flows containing multiple page objects in the "src/main/java/pagefactory/businessFlows"
- Preferably start each flow or the page object method with the line
   `Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());`
- And end it with
   `Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());`
- This will create log messages in the logs.
- Divide page objects and flows based on your application modules for e.g. create all the Login Page Objects under Login package or all Order flows under Order package.
- Once the Page Objects are created start writing the Feature files, use the same application module strategy to divide your Feature files.
- Add tag names to scenario 
    - based on the module to which the scenario belongs for e.g. if there are 10 scenarios for Login add @module_login to all of them. 
    - based on the type of the test case for e.g. if out of the 10 TCs 5 belong to sanity and all 10 belong to regression add tags like @sanity and @regression accordingly.

## Tags
Its very important to understand how to pass Tags if you are using it to execute your Test Cases
Below are some examples on how it can be passed:

Expression  | Description
------------- | -------------
@fast  | Scenarios tagged with @fast
@wip and not @slow  | Scenarios tagged with @wip that aren’t also tagged with @slow
@smoke and @fast | Scenarios tagged with both @smoke and @fast
@gui or @database | Scenarios tagged with either @gui or @database

##Execution
- Using TestRunner class
  -  The scenario can be executed by using the TestRunner class present at "src/test/java/step_definitions/TestRunner.java"
     ```java
     @CucumberOptions(
     features="src/test/Features",
     glue={"step_definitions"},
     monochrome = true,
     plugin = {"pretty","html:target/Html/Reports.html"},
     tags = "@sanity1 or @sanity2"
     )
     public class TestRunner { }
     ```
     You can add the scenario tags as shown above for the scenarios to be executed

- Using Maven
  -  If you are using Maven and want to run a subset of scenarios tagged with @sanity1
    ```
     mvn test -Dcucumber.filter.tags="@sanity1"
    ```
  Some additional supported properties are below that you can pass at runtime using maven 
  -  cucumber.execution.limit=       # number of scenarios to execute (CLI only).
  -  cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
  -  cucumber.features=              # command separated paths to feature files. example: path/to/example.feature, path/to/other.feature
  -  cucumber.filter.name=           # regex. example: .*Hello.*
  -  cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
  -  cucumber.glue=                  # comma separated package names. example: com.example.glue
  -  cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json

  Note: This uses the TestRunner bydefault for execution.

-  The individual scenarios can be executed using the IDE like Eclipse or IntelliJ where you can right click on the scenario and select execute to execute it.

##Reports:
-  The framework creates the stock cucumber html report.
-  The report is placed at "target/Html"

##Logs:
-  The framework creates logs using Log4j.
-  Log4j properties files is present at the project's root folder with the name log4j.properties.
-  A new log file with the naming format "Log_dd-mm-yyyy-hh-mm-ss.log" will be created for each run
-  Its the user's responsibility to delete the old unwanted logs
