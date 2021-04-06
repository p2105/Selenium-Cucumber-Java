package step_definitions.Expedia;

import gherkin.lexer.Pa;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseStepDefinition;

/**
 * The type Login step defs.
 */
public class ExpediaStepDefs {

    private final WebDriver driver;

    /**
     * Instantiates a new Login step defs.
     *
     * @param baseStepDefinition the base step definition
     */
    public ExpediaStepDefs(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }

    @When("John looks for a flight+accommodation from {string} to {string}")
    public void johnLooksForAFromTo(String fromCity, String toCity) {
        PageObjectManager.getExpediaHomePage(driver).enterDestination(toCity);
        PageObjectManager.getExpediaHomePage(driver).clickAddFlight();
        PageObjectManager.getExpediaHomePage(driver).enterOrigin(fromCity);
    }

    @Then("the result page contains travel option for the chosen destination")
    public void theResultPageContainsTravelOptionForTheChosenDestination() {
    }
}
