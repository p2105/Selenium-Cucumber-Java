package pagefactory.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Log;
import support.WebElementHelperMethods;

import java.util.List;

/**
 * This the Cyclos Login Page Object and contains all the methods belonging to it.
 */

public class ExpediaHomePage extends WebElementHelperMethods {

    private final By lnkstaysOption = new By.ByCssSelector("[aria-controls='wizard-hotel-pwa-v2']");

    private final By btnGoingTo = new By.ByCssSelector("[aria-label='Going to']");
    private final By txtGoingTo = new By.ByCssSelector("#location-field-destination");
    private final By liFirstSuggestionForGoingTo = new By.ByCssSelector("[data-stid='location-field-destination-results']>li");

    private final By btnLeavingFrom = new By.ByCssSelector("[aria-label='Leaving from']");
    private final By txtLeavingFrom = new By.ByCssSelector("#location-field-origin");
    private final By liFirstSuggestionForLeavingFrom = new By.ByCssSelector("[data-stid='location-field-origin-results']>li");

    private final By chkboxAddFlight = new By.ByCssSelector("#add-flight-switch");
    private final By btnCheckInDate = new By.ByCssSelector("#d1-btn");
    private final By btnCheckOutDate = new By.ByCssSelector("#d2-btn");
    private final By h2MonthTitle = new By.ByCssSelector(".uitk-date-picker-month-name.uitk-type-medium");
    private final By btnPrevMonth = new By.ByXPath("//*[@aria-labelledby='prevMonth-title']//parent::button");
    private final By btnNextMonth = new By.ByXPath("//*[@aria-labelledby='nextMonth-title']//parent::button");
    private final By btnSearch = new By.ByCssSelector("[data-testid='submit-button']");

    /**
     * Instantiates the new duckduckgo page.
     *
     * @param driver the driver
     */
    public ExpediaHomePage(WebDriver driver){
        super(driver);
    }

    /**
     * Launch DuckDuckGo Page.
     *
     * @param url the url
     */
    public void launchExpediaPage(String url){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.navigate().to(url);
        Log.debug("Waiting for Page Load");
        waitForPageLoad();
        waitForElement(btnSearch);
        if(!isElementVisible(btnSearch)){
            Log.error("Page has not been loaded correctly");
            throw new RuntimeException("Page has not been loaded correctly");
        }
        driver.manage().window().maximize();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    public void enterOrigin(String originCity){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(btnLeavingFrom).click();
        Log.debug("Clicked on Going To button");
        driver.findElement(txtLeavingFrom).sendKeys(originCity);
        Log.debug("Entered Origin city " + originCity);
        //click on the first element from the suggestions
//        driver.findElement(divGoingToContainer).findElements(By.tagName("strong")).get(0).click();
        driver.findElements(liFirstSuggestionForLeavingFrom).get(0).click();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    public void enterDestination(String destinationCity){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(btnGoingTo).click();
        Log.debug("Clicked on Going To button");
        driver.findElement(txtGoingTo).sendKeys(destinationCity);
        Log.debug("Entered destination " + destinationCity);
        //click on the first element from the suggestions
//        driver.findElement(divGoingToContainer).findElements(By.tagName("strong")).get(0).click();
        driver.findElements(liFirstSuggestionForGoingTo).get(0).click();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }


    public void clickStaysOption(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(lnkstaysOption).click();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    public void clickAddFlight(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(chkboxAddFlight).click();
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    public void searchFlightPlusAccommodation(String fromCity, String toCity, String checkInDate, String checkOutDate, int noOfAdults, int noOfChilds)
    {
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickStaysOption();
        enterDestination(toCity);
        clickAddFlight();
        enterOrigin(fromCity);
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
