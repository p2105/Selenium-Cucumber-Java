package pagefactory.DuckDuckGo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

import java.nio.file.FileSystems;

/**
 * This the DuckDuckGo Search Results Page Object and contains all the methods belonging to it.
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
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        String searchBoxText = driver.findElement(txtSearchBox).getAttribute("value");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return searchBoxText;
    }

    /**
     * Get location name from the page.
     *
     * @return the string containing the location name from the span on the right hand side of the page
     */
    public String getLocationNameFromSpan(){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        String locationNameFromSpan = driver.findElement(spanLocationName).getText();
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return locationNameFromSpan;
    }

    /**
     * Take screenshot of results page.
     *
     * @param path the relative path where the screenshot has to be saved
     */
    public void takeScreenshotOfResultsPage(String path){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        takeScreenshot(path);
        Log.info("Screenshot taken at " + FileSystems.getDefault().getPath(path).normalize().toAbsolutePath().toString());
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
