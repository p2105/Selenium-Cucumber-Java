package managers;

import org.openqa.selenium.WebDriver;
import pagefactory.Login.LoginPage;
import pagefactory.businessFlows.LoginFlow;


public class PageObjectManager {

//    private PageObjectManager() {
//    }

    //Flows
    public static LoginFlow getLoginFlow(WebDriver driver) {
        return new LoginFlow(driver);
    }

    //Page Objects
    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

}
