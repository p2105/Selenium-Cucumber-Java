package managers;

import org.openqa.selenium.WebDriver;
import pagefactory.DuckDuckGo.DuckDuckGoHomePage;
import pagefactory.DuckDuckGo.DuckDuckGoSearchResultsPage;
import pagefactory.businessFlows.SearchDuckDuckGoFlow;


/**
 * This class provides methods to return all PageObjects and BusinessFlows defined in the pageFactory class.
 * Every new PageObject or the BusinessFlow must be defined here to be used in StepDefs.
 */

public class PageObjectManager {

    //Flows
    public static SearchDuckDuckGoFlow getSearchDuckDuckGoFlow(WebDriver driver){ return new SearchDuckDuckGoFlow(driver); }

    //Page Objects

    public static DuckDuckGoHomePage getDuckDuckGoPage(WebDriver driver) { return new DuckDuckGoHomePage(driver); }
    public static DuckDuckGoSearchResultsPage getDuckDuckGoSearchResultsPage (WebDriver driver) { return new DuckDuckGoSearchResultsPage(driver); }
}
