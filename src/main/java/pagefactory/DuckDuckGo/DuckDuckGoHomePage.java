package pagefactory.DuckDuckGo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

/**
 * This the Cyclos Login Page Object and contains all the methods belonging to it.
 */

public class DuckDuckGoHomePage extends WebElementHelperMethods {

    private final By txtSearchBox = new By.ByCssSelector("#search_form_input_homepage");
    private final By btnSearch = new By.ByCssSelector("#search_button_homepage");

    /**
     * Instantiates the new duckduckgo page.
     *
     * @param driver the driver
     */
    public DuckDuckGoHomePage(WebDriver driver){
        super(driver);
    }

    /**
     * Launch DuckDuckGo Page.
     *
     * @param url the url
     */
    public void launchDuckDuckGoPage(String url){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.navigate().to(url);
        Log.debug("Waiting for Page Load");
        waitForPageLoad();
        waitForElement(txtSearchBox);
        if(!isElementVisible(txtSearchBox)){
            Log.error("Page has not been loaded correctly");
            throw new RuntimeException("Page has not been loaded correctly");
        }
        driver.manage().window().maximize();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    public void enterSearchTextAndClickSearch(String txtToBeSearched)
    {
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(txtSearchBox).sendKeys(txtToBeSearched);
        Log.debug("Search Text + " + txtToBeSearched + " entered" );
        driver.findElement(btnSearch).click();
        Log.debug("Search button clicked" );
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
