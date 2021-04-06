package step_definitions;

import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import managers.FileReaderManager;

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
     * This is the base method for the DuckDuckGo page.
     */
    @Given("John is on the DuckDuckGo Page")
    public void johnIsOnTheDuckDuckGoPage() {
        PageObjectManager.getDuckDuckGoPage(driver).launchDuckDuckGoPage(FileReaderManager.getConfigReader().getDuckDuckGoAppUrl());
    }


    /**
     * John navigate to the expedia website.
     */
    @Given("John navigate to the Expedia website")
    public void johnNavigateToTheExpediaWebsite() {
        PageObjectManager.getExpediaHomePage(driver).launchExpediaPage(FileReaderManager.getConfigReader().getExpediaAppUrl());
    }


}
