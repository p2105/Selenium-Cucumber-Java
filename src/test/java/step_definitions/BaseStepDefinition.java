package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.FileReaderManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseStepDefinition {

    WebDriver driver;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    @Before
    public WebDriver beforeScenario(){
        System.out.println("Inside Before hooks - Getting driver");
        return getDriver();
    }

    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", "failure screenshot");
        }
        System.out.println("Inside After hooks - Closing driver");
        closeDriver();
    }

    public WebDriver getDriver() {
        if(driver == null) {
            System.out.println("Creating new driver");
            driver = createLocalDriver();
        }else {
            System.out.println("Returning existing driver");
        }
        return driver;
    }

    private WebDriver createLocalDriver() {
        String driverType = FileReaderManager.getConfigReader().getBrowser();
        switch (driverType.toUpperCase()) {
            case "FIREFOX" : driver = new FirefoxDriver();
                break;
            case "CHROME" :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getConfigReader().getDriverPath() + "/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(FileReaderManager.getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
                break;

        }

        if(FileReaderManager.getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
