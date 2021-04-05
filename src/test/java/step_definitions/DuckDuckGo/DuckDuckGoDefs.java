package step_definitions.DuckDuckGo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseStepDefinition;

/**
 * The type Login step defs.
 */
public class DuckDuckGoDefs {

    private final WebDriver driver;
    String searchText = "";
    String screenshotDirectory = "target/images";

    /**
     * Instantiates a new Login step defs.
     *
     * @param baseStepDefinition the base step definition
     */
    public DuckDuckGoDefs(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }


    /**
     * This methods searches for a specific location on DuckDuckGo.
     *
     * @param txtToBeSearched the txt to be searched
     */
    @When("he searches for the location {string}")
    public void heSearchesForTheLocation(String txtToBeSearched) {
        searchText = txtToBeSearched;
        PageObjectManager.getDuckDuckGoPage(driver).enterSearchTextAndClickSearch(searchText);
    }

    /**
     * This methods verifies the details on the results page and take screenshot in directory target/images.
     */
    @Then("the page should contain results from that location")
    public void thePageShouldContainResultsFromThatLocation() {
        PageObjectManager.getSearchDuckDuckGoFlow(driver).matchLocationName(searchText);
        PageObjectManager.getDuckDuckGoSearchResultsPage(driver).takeScreenshotOfResultsPage(screenshotDirectory + "/" + searchText + ".png");
    }
}
