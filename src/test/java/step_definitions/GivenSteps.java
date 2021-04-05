package step_definitions;

import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import managers.FileReaderManager;

import java.io.File;

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
        PageObjectManager.getDuckDuckGoPage(driver).launchDuckDuckGoPage(FileReaderManager.getConfigReader().getAppUrl());
    }
}
