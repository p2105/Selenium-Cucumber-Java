package step_definitions;

import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;


/**
 * The type Given steps.
 */
public class GivenSteps {

    private final WebDriver driver;

    /**
     * Instantiates a new Given steps.
     *
     * @param baseStepDefinition the base step definition
     */
    public GivenSteps(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }


    /**
     * User is on the login page.
     */
    @Given("John is on the Login Page")
    public void userIsOnTheLoginPage() {
        String url = PageObjectManager.getLoginFlow(driver).getAppUrl();
        PageObjectManager.getLoginPage(driver).launchCyclos(url);
    }

}
