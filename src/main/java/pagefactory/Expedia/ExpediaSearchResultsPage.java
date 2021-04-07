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
            Log.info(element.getText());
            stringNeighbourhood.add(element.getText());
        }
        return stringNeighbourhood.contains(expectedToCity);
    }

}
