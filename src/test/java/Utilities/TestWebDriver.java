package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestWebDriver {

    public WebDriver setChromeDriver() {
        WebDriver driver = null;

        System.getProperty("webdriver.chrome.driver","/Selenium-UI-TestAutomation/src/test/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        return driver;
    }
}
