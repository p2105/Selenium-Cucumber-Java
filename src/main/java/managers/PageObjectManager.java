package managers;

import org.openqa.selenium.WebDriver;
import pagefactory.Login.LoginPage;
import pagefactory.businessFlows.LoginFlow;


/**
 * This class provides methods to return all PageObjects and BusinessFlows defined in the pageFactory class.
 * Every new PageObject or the BusinessFlow must be defined here to be used in StepDefs.
 */

public class PageObjectManager {

    //Flows

    /**
     * Gets login flow.
     *
     * @param driver the driver
     * @return the login flow
     */
    public static LoginFlow getLoginFlow(WebDriver driver) {
        return new LoginFlow(driver);
    }


    //Page Objects

    /**
     * Gets login page.
     *
     * @param driver the driver
     * @return the login page
     */
    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

}
