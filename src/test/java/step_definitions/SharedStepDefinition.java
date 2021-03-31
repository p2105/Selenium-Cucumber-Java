package step_definitions;

import enums.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SharedStepDefinition {

    WebDriver driver;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    @Before
    public WebDriver beforeScenario(){
        System.out.println("Inside Before hooks - Getting driver");
        return getDriver();
    }

    @After
    public void afterScenario(){
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
        DriverType driverType = FileReaderManager.getConfigReader().getBrowser();
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
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
