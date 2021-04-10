package pagefactory.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.Log;
import support.WebElementHelperMethods;

import java.time.LocalDate;
import java.util.List;

/**
 * This the Expedia Home Page Object and contains all the methods belonging to it.
 */
public class ExpediaHomePage extends WebElementHelperMethods {

    private final By lnkStaysOption = new By.ByCssSelector("[aria-controls='wizard-hotel-pwa-v2']");
    private final By lnkFlightOption = new By.ByCssSelector("[aria-controls='wizard-flight-pwa']");

    private final By btnGoingTo = new By.ByCssSelector("[aria-label='Going to']");
    private final By txtGoingTo = new By.ByCssSelector("[id^='location-field-'][id$='destination']");
    private final By liFirstSuggestionForFromAndTo = new By.ByCssSelector("[data-stid^='location-field-']>li");

    private final By btnLeavingFrom = new By.ByCssSelector("[aria-label='Leaving from']");
    private final By txtLeavingFrom = new By.ByCssSelector("[id^='location-field-'][id$='origin']");

    private final By chkboxAddFlight = new By.ByCssSelector("#add-flight-switch");
    private final By lnkRoundTrip = new By.ByCssSelector("[aria-controls='wizard-flight-tab-roundtrip']");

    private final By btnCheckInDate = new By.ByCssSelector("#d1-btn");
    private final By btnCheckOutDate = new By.ByCssSelector("#d2-btn");
    private final By h2MonthTitle = new By.ByCssSelector(".uitk-date-picker-month-name.uitk-type-medium");
    private final By btnNextMonth = new By.ByXPath("//*[@aria-labelledby='nextMonth-title']//parent::button");
    private final By btnSearch = new By.ByCssSelector("[data-testid='submit-button']");
    private final By datePickerDone = new By.ByXPath("//span[text()='Done']");

    private final By btnNoOfTravellers = new By.ByCssSelector("[data-testid^='travelers-field']");
    private final By btnAdjustNoOfTravellers = new By.ByXPath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']//parent::button");
    private final By txtNoOfAdults = new By.ByCssSelector("#adult-input-0");
    private final By txtNoOfChildrens = new By.ByCssSelector("#child-input-0");
    private final By btnNoOfGuestsDone = new By.ByCssSelector("[data-testid='guests-done-button']");
    private final By btnSubmit = new By.ByCssSelector("[data-testid='submit-button']");

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
     * @param url the url of the Expedia application
     */
    public void launchExpediaPage(String url){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.navigate().to(url);
        Log.debug("Waiting for Page Load");
        waitForPageLoad();
        waitForElement(btnSearch);
        if(!isElementVisible(btnSearch)){
            Log.error("Page has not been loaded correctly");
            throw new RuntimeException("Page has not been loaded correctly");
        }
        driver.manage().window().maximize();
        Log.info("Page launched!");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Enter origin city.
     *
     * @param originCity the origin city
     * @throws InterruptedException the interrupted exception
     */
    public void enterOrigin(String originCity) throws InterruptedException {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(btnLeavingFrom).click();
        Log.debug("Clicked on Going To button");
        driver.findElement(txtLeavingFrom).sendKeys(originCity);
        Thread.sleep(2);
        driver.findElement(txtLeavingFrom).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//span[text()='Search for “"+ originCity +"”']")).click();
        Log.info("Origin " + originCity + " entered.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Enter destination city.
     *
     * @param destinationCity the destination city
     * @throws InterruptedException the interrupted exception
     */
    public void enterDestination(String destinationCity) throws InterruptedException {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(btnGoingTo).click();
        Log.debug("Clicked on Going To button");
        driver.findElement(txtGoingTo).sendKeys(destinationCity);
        driver.findElement(txtGoingTo).sendKeys(Keys.ENTER);
        Thread.sleep(2);
//        driver.findElement(By.xpath("//span[contains(text(), 'Search for')]")).click();
        Log.info("Destination " + destinationCity + " entered");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    private void waitForCitiesToBeShown(WebElement elementToBeChecked) throws InterruptedException {
        int i = 0;
        while(i <= 10){
            Log.info("Current first suggestion - " + elementToBeChecked.getText());
            if(!elementToBeChecked.getText().equals(""))
            {break;}
            else
            {Thread.sleep(1);}
            i++;
        }
    }

    /**
     * Click stays option.
     */
    public void clickStaysOption(){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(lnkStaysOption).click();
        Log.info("Clicked on Stays Option.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click Flight option.
     */
    public void clickFlightOption(){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(lnkFlightOption).click();
        Log.info("Flights option clicked.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click Round Trip option.
     */
    public void clickRoundTripOption(){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(lnkRoundTrip).click();
        Log.info("RoundTrip option clicked.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click add flight.
     */
    public void clickAddFlight(){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.findElement(chkboxAddFlight).click();
        Log.info("Add Flight Option clicked.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Enter start date.
     *
     * @param noOfDaysInAdvance the no of days in advance
     * @throws InterruptedException the interrupted exception
     */
    public void enterStartDate(int noOfDaysInAdvance) throws InterruptedException {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(btnCheckInDate);
        LocalDate startDate =  LocalDate.now().plusDays(noOfDaysInAdvance);
        Log.debug("Travel Start Date " + startDate);
        String startDateMonth = startDate.getMonth().toString();
        clickNextMonthUntilRequiredMonthIsFound(startDateMonth);
        String selectedDateCss = "[data-day='" + String.format("%d", startDate.getDayOfMonth()) + "']";
        Log.debug("Date CSS - " + selectedDateCss);
        driver.findElement(By.cssSelector(selectedDateCss)).click();
        Thread.sleep(3);
        clickElement(datePickerDone);
        Log.info("Start Date " + startDate + " selected.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Enter end date.
     *
     * @param noOfDaysInAdvance the no of days in advance
     * @param noOfTravelDays    the no of travel days
     * @throws InterruptedException the interrupted exception
     */
    public void enterEndDate(int noOfDaysInAdvance, int noOfTravelDays) throws InterruptedException {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(btnCheckOutDate);
        LocalDate endDate =  LocalDate.now().plusDays(noOfDaysInAdvance + noOfTravelDays);
        Log.debug("Travel End Date " + endDate);
        String endDateMonth = endDate.getMonth().toString();
        clickNextMonthUntilRequiredMonthIsFound(endDateMonth);
        String selectedDateCss = "[data-day='" + String.format("%d", endDate.getDayOfMonth()) + "']";
        Log.debug("Date CSS - " + selectedDateCss);
        driver.findElement(By.cssSelector(selectedDateCss)).click();
        Thread.sleep(3);
        clickElement(datePickerDone);
        Log.info("Start Date " + endDate + " selected.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    private void clickNextMonthUntilRequiredMonthIsFound(String requiredMonth)
    {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        List<WebElement> currentMonth = driver.findElements(h2MonthTitle);
        boolean monthFound = false;
        int maxClick = 0;
        while(!monthFound)
        {
            currentMonth = driver.findElements(h2MonthTitle);
            Log.debug("Current Months " + currentMonth.get(0).getText().split(" ")[0]
                    + " - " + currentMonth.get(1).getText().split(" ")[0]);

            if(currentMonth.get(0).getText().split(" ")[0].equalsIgnoreCase(requiredMonth)){
                Log.debug("Month Found " + requiredMonth);
                monthFound = true;
            }
            else if(currentMonth.get(1).getText().split(" ")[0].equalsIgnoreCase(requiredMonth)){
                Log.debug("Month Found " + requiredMonth);
                monthFound = true;
            }
            else
            {
                clickElement(btnNextMonth);
                maxClick++;
            }
            if(maxClick == 13) throw new RuntimeException("Month " + requiredMonth + " not found.");
        }
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Sets no of passengers either adults or child.
     * No of Adults cannot be less than 1
     *
     * @param noOfPassengers the no of passengers
     * @param passengerType  the passenger type
     * @throws InterruptedException the interrupted exception
     */
    public void setNoOfPassenger(int noOfPassengers, String passengerType) throws InterruptedException {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(btnNoOfTravellers);
        WebElement reduceNoOfAdults = null, increaseNoOfAdults = null;
        int currentNoOfPassengers = 0;
        if(passengerType.equalsIgnoreCase("adults")){
            if(noOfPassengers < 1) throw new RuntimeException("No of adults cannot be less than 1");
            reduceNoOfAdults = driver.findElements(btnAdjustNoOfTravellers).get(0);
            increaseNoOfAdults = driver.findElements(btnAdjustNoOfTravellers).get(1);
            currentNoOfPassengers = Integer.parseInt(driver.findElement(txtNoOfAdults).getAttribute("value"));
        }
        else if(passengerType.equalsIgnoreCase("children")){
            reduceNoOfAdults = driver.findElements(btnAdjustNoOfTravellers).get(2);
            increaseNoOfAdults = driver.findElements(btnAdjustNoOfTravellers).get(3);
            currentNoOfPassengers = Integer.parseInt(driver.findElement(txtNoOfChildrens).getAttribute("value"));
        }
        else{
            throw new RuntimeException("Passenger type " + passengerType + " has not been configured");
        }

        int difference = 0;
        if(currentNoOfPassengers < noOfPassengers)
        {
            difference = noOfPassengers - currentNoOfPassengers;
            while(difference != 0){
                clickElement(increaseNoOfAdults);
                Thread.sleep(2);
                difference--;
            }
        }

        if(currentNoOfPassengers > noOfPassengers)
        {
            difference = currentNoOfPassengers - noOfPassengers;
            while(difference != 0){
                clickElement(reduceNoOfAdults);
                Thread.sleep(2);
                difference--;
            }
        }
        clickElement(btnNoOfGuestsDone);
        Log.info( passengerType + " " + noOfPassengers + " entered.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }


    /**
     * Set child age.
     *
     * @param chiildCount the chiild count
     * @param childAge    the child age
     */
    public void setChildAge(int chiildCount, int childAge){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        if(childAge < 2) throw new RuntimeException("Chile age cannot be less than 2");
        clickElement(btnNoOfTravellers);
        By selectChildAge = new By.ByCssSelector("#child-age-input-0-" + String.valueOf(chiildCount - 1));//the last digit changes with the count of the child
        Select objSelect = new Select(driver.findElement(selectChildAge));
        objSelect.selectByVisibleText(String.valueOf(childAge));
        clickElement(btnNoOfGuestsDone);
        Log.info("Child " + chiildCount + ", Age " + childAge + " selected.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click submit.
     */
    public void clickSubmit()
    {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(btnSubmit);
        Log.info("Clicked button Submit.");
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }
}
