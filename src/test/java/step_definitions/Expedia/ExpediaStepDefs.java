package step_definitions.Expedia;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseStepDefinition;
import profiles.John;

/**
 * This class contains step defs for Expedia application.
 */
public class ExpediaStepDefs {

    private final WebDriver driver;
    private String fromCity = "", toCity = "";

    /**
     * Instantiates a new Login step defs.
     *
     * @param baseStepDefinition the base step definition
     */
    public ExpediaStepDefs(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }

    /**
     * John looks for a from to.
     *
     * @param fromCity the from city
     * @param toCity   the to city
     * @throws InterruptedException the interrupted exception
     */
    @When("John looks for a flight+accommodation from {string} to {string}")
    public void johnLooksForAFromTo(String fromCity, String toCity) throws InterruptedException {
        this.fromCity = fromCity;
        this.toCity = toCity;
        PageObjectManager.getExpediaFlow(driver).flowBookTicketsForJohn(fromCity, toCity,
                John.noOfDaysInAdvanceToTravel, John.noOfAdultsTravelling, John.noOfChildrenTravelling, John.noOfDaysPlanned);
    }

    /**
     * The result page contains travel option for the chosen destination.
     */
    @Then("the result page contains travel option for the chosen destination")
    public void theResultPageContainsTravelOptionForTheChosenDestination() {
        Assert.assertTrue(PageObjectManager.getExpediaSearchResultsPage(driver).verifyFromCity(this.fromCity));
        Assert.assertTrue(PageObjectManager.getExpediaSearchResultsPage(driver).verifyToCity(this.toCity));
        Assert.assertTrue(PageObjectManager.getExpediaSearchResultsPage(driver).verifyNeighbourhoodList(this.toCity));
    }
}
