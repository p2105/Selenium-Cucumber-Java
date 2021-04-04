package step_definitions;

import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;


public class GivenSteps {

    private final WebDriver driver;

    public GivenSteps(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }


    @Given("John is on the Login Page")
    public void userIsOnTheLoginPage() {
        String url = PageObjectManager.getLoginFlow(driver).getAppUrl();
        PageObjectManager.getLoginPage(driver).launchCyclos(url);
    }

}
