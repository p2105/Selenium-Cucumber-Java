package pagefactory.DuckDuckGo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

/**
 * This the Cyclos Login Page Object and contains all the methods belonging to it.
 */
public class DuckDuckGoSearchResultsPage extends WebElementHelperMethods {

    private final By txtSearchBox = new By.ByCssSelector("#search_form_input");
    private final By spanLocationName = new By.ByCssSelector(".module__title__link");

    /**
     * Instantiates the new duckduckgo page.
     *
     * @param driver the driver
     */
    public DuckDuckGoSearchResultsPage(WebDriver driver){
        super(driver);
    }

    /**
     * Get search box text string.
     *
     * @return the string
     */
    public String getSearchBoxText(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        String searchBoxText = driver.findElement(txtSearchBox).getText();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return searchBoxText;
    }

    /**
     * Get location name from the page.
     *
     * @return the string
     */
    public String getLocationNameFromSpan(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        String locationNameFromSpan = driver.findElement(spanLocationName).getText();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return locationNameFromSpan;
    }

    /**
     * Take screenshot of results page.
     *
     * @param path the path
     */
    public void takeScreenshotOfResultsPage(String path){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        takeScreenshot(path);
        Log.debug("Screenshot taken at " + path);
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
