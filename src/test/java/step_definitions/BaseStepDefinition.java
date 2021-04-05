package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import support.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The type Base step definition.
 */
public class BaseStepDefinition {

    /**
     * The Driver.
     */
    WebDriver driver;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String FIREFOX_BIN_PROPERTY = "webdriver.firefox.bin";

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    /**
     * This will run before every scenario.
     *
     * @param scenario the scenario
     * @return the web driver
     */
    @Before
    public WebDriver beforeScenario(Scenario scenario) {
        initializeLogs(scenario.getName());
        System.out.println("Inside Before hooks - Getting driver");
        return getDriver();
    }

    /**
     * This will run after every scenario.
     *
     * @param scenario the scenario
     */
    @After
    public void afterScenario(Scenario scenario) {
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        if (scenario.isFailed()) {
            Log.error("TC failed!!!");
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", "failure screenshot");
        }
        Log.info("Inside After hooks - Closing driver");
        closeDriver();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.endTestCase();
    }

    /**
     * Initialize Log4j and print the beginning of the TC.
     *
     * @param name of the scenario
     */
    private void initializeLogs(String name) {
        PropertyConfigurator.configure("log4j.properties");
        Log.setLogLevel(FileReaderManager.getConfigReader().getLogLevel());
        Log.startTestCase(name);
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Creating new driver");
            driver = createLocalDriver();
        } else {
            System.out.println("Returning existing driver");
        }
        return driver;
    }

    /**
     * This will create a new driver object.
     *
     * @return the driver
     */
    private WebDriver createLocalDriver() {
        String driverType = FileReaderManager.getConfigReader().getBrowser();
        switch (driverType.toUpperCase()) {
            case "FIREFOX":
                System.setProperty(FIREFOX_BIN_PROPERTY, FileReaderManager.getConfigReader().getFirefoxExecutablePath());
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getConfigReader().getDriverPath() +"/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "IE":
                System.setProperty(IE_DRIVER_PROPERTY, FileReaderManager.getConfigReader().getDriverPath() + "/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "CHROME":
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getConfigReader().getDriverPath() + "/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getConfigReader().getMaxWaitInSeconds(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Close driver.
     */
    public void closeDriver() {
        driver.close();
        if(!FileReaderManager.getConfigReader().getBrowser().equalsIgnoreCase("FIREFOX"))
        {
            driver.quit();
            driver = null;
        }
    }
}
