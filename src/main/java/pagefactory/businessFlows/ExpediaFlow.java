package pagefactory.businessFlows;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

/**
 * This class contains all the reusable flows for Expedia application.
 */
public class ExpediaFlow extends WebElementHelperMethods {

    /**
     * Instantiates a new ExpediaFlow Object.
     *
     * @param driver the driver
     */
    public ExpediaFlow(WebDriver driver){ super(driver); }

    /**
     * Flow book tickets for john.
     *
     * @param fromCity                  the from city
     * @param toCity                    the to city
     * @param noOfDaysInAdvanceToTravel the no of days in advance to travel
     * @param noOfAdultsTravelling      the no of adults travelling
     * @param noOfChildrenTravelling    the no of children travelling
     * @param noOfDaysPlanned           the no of days planned
     * @throws InterruptedException the interrupted exception
     */
    public void flowBookTicketsForJohn(String fromCity, String toCity, int noOfDaysInAdvanceToTravel, int noOfAdultsTravelling,
                                       int noOfChildrenTravelling, int noOfDaysPlanned) throws InterruptedException{
        PageObjectManager.getExpediaHomePage(driver).clickStaysOption();
        PageObjectManager.getExpediaHomePage(driver).enterDestination(toCity);
        PageObjectManager.getExpediaHomePage(driver).clickAddFlight();
        PageObjectManager.getExpediaHomePage(driver).enterOrigin(fromCity);
        PageObjectManager.getExpediaHomePage(driver).enterStartDate(noOfDaysInAdvanceToTravel);
        PageObjectManager.getExpediaHomePage(driver).enterEndDate(noOfDaysInAdvanceToTravel, noOfDaysPlanned);
        PageObjectManager.getExpediaHomePage(driver).setNoOfPassenger(noOfAdultsTravelling, "adults");
        PageObjectManager.getExpediaHomePage(driver).setNoOfPassenger(noOfChildrenTravelling, "children");
        PageObjectManager.getExpediaHomePage(driver).clickSubmit();
    }
}
