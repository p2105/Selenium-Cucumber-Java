package step_definitions;

import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;


public class GivenSteps {

    WebDriver driver;

    public GivenSteps(SharedStepDefinition sharedStepDefinition){
        driver = sharedStepDefinition.getDriver();
    }


    @Given("John is on the Login Page")
    public void is_on_the_login_page() {
        String url = PageObjectManager.getLoginFlow(driver).getAppUrl();
        PageObjectManager.getLoginPage(driver).launchCyclos(url);
    }

}
