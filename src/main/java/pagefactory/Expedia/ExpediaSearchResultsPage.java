package pagefactory.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Log;
import support.WebElementHelperMethods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This the Expedia Search Results Page Object and contains all the methods belonging to it.
 */
public class ExpediaSearchResultsPage extends WebElementHelperMethods {

    private final By divNeighbourHoodList = new By.ByCssSelector("[data-test-id='content-hotel-neighborhood']");
    private final By txtFromCity = new By.ByCssSelector("#trip-origin-input");
    private final By txtToCity = new By.ByCssSelector("#hotels-destination-input");
    private final By divArrivalDepartureResults = new By.ByCssSelector("[data-test-id='arrival-departure']");
    private final By selectSortResults = new By.ByCssSelector("[data-test-id='sortDropdown']");


    /**
     * Instantiates the new Expedia Search Results page.
     *
     * @param driver the driver
     */
    public ExpediaSearchResultsPage(WebDriver driver){
        super(driver);
    }

    /**
     * Verify from city.
     *
     * @param expectedFromCity the expected from city
     * @return true if the expected city is a part of actual city
     * have used contains for cases like New York City and New York
     */
    public boolean verifyFromCity(String expectedFromCity){
        String actualFromCity = driver.findElement(txtFromCity).getAttribute("value");
        Log.info("Searching " + expectedFromCity + " in " + actualFromCity);
        return actualFromCity.contains(expectedFromCity);
    }

    /**
     * Verify to city boolean.
     *
     * @param expectedToCity the expected to city
     * @return true if the expected city is a part of actual city
     * have used contains for cases like New York City and New York
     */
    public boolean verifyToCity(String expectedToCity){
        String actualToCity = driver.findElement(txtToCity).getAttribute("value");
        Log.info("Searching " + expectedToCity + " in " + actualToCity);
        return actualToCity.contains(expectedToCity);
    }

    /**
     * Verify neighbourhood list boolean.
     *
     * @param expectedToCity the expected to city
     * @return true if the expected city is a part of the list of all the Neighbourhoods
     * since Expedia not only provides the options for the searched location but also the nearby locations
     */
    public boolean verifyNeighbourhoodList(String expectedToCity){
        List<WebElement> elementNeighbourhood = driver.findElements(divNeighbourHoodList);
        List<String> stringNeighbourhood = new ArrayList<String>();
        for (WebElement element : elementNeighbourhood) {
            Log.info("Searching for " + expectedToCity + " in " + element.getText());
            stringNeighbourhood.add(element.getText());
        }
        return stringNeighbourhood.contains(expectedToCity);
    }

    public boolean isSortButtonEnabled(){
        return driver.findElement(selectSortResults).isEnabled();
    }

    public void waitUntilResultsAreDisplayed() throws InterruptedException {
        int maxCount = 0;
        while(!isSortButtonEnabled()){
            Log.info("Waiting for results to be displayed...");
            Thread.sleep(1);
            maxCount++;
            if(maxCount == 30000) {
                Log.error("Results are not displayed correctly");
                throw new RuntimeException("Results are not displayed correctly");
            }
        }
    }

    /**
     * Verify arrival and departure city names.
     *
     * @param expectedOriginCity the expected Origin city
     * @param expectedDestinationCity the expected to city
     * @return true if the expected city is a part of the list of all the arrival and departure city names
     * since Expedia not only provides the options for the searched location but also the nearby locations
     */
    public boolean verifyArrivalAndDepartureList(String expectedOriginCity, String expectedDestinationCity) throws InterruptedException {
        waitUntilResultsAreDisplayed();
        List<WebElement> elementArrivalDepartureList = driver.findElements(divArrivalDepartureResults);
        List<String> stringNeighbourhood = new ArrayList<String>();
        for (WebElement element : elementArrivalDepartureList) {
            Log.info("Searching for " + expectedOriginCity + " in " + element.getText().split("-")[0]);
            Log.info("Searching for " + expectedDestinationCity + " in " + element.getText().split("-")[1]);
            if(!element.getText().split("-")[0].contains(expectedOriginCity)) {
                Log.error("Invalid city name " + element.getText().split("-")[0] + " found");
                return false;
            }
            if(!element.getText().split("-")[1].contains(expectedDestinationCity)) {
                Log.error("Invalid city name " + element.getText().split("-")[1] + " found");
                return false;
            }
        }
        return true;
    }

}
