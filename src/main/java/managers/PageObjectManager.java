package managers;

import org.openqa.selenium.WebDriver;
import pagefactory.DuckDuckGo.DuckDuckGoHomePage;
import pagefactory.DuckDuckGo.DuckDuckGoSearchResultsPage;
import pagefactory.Expedia.ExpediaHomePage;
import pagefactory.Expedia.ExpediaSearchResultsPage;
import pagefactory.businessFlows.ExpediaFlow;
import pagefactory.businessFlows.SearchDuckDuckGoFlow;


/**
 * This class provides methods to return all PageObjects and BusinessFlows defined in the pageFactory package.
 * Every new PageObject or a new BusinessFlow must be defined here to be used in StepDefs.
 */

public class PageObjectManager {

    //Flows
    public static SearchDuckDuckGoFlow getSearchDuckDuckGoFlow(WebDriver driver){ return new SearchDuckDuckGoFlow(driver); }
    public static ExpediaFlow getExpediaFlow(WebDriver driver){ return new ExpediaFlow(driver); }

    //DuckDuckGo Page Objects
    public static DuckDuckGoHomePage getDuckDuckGoPage(WebDriver driver) { return new DuckDuckGoHomePage(driver); }
    public static DuckDuckGoSearchResultsPage getDuckDuckGoSearchResultsPage (WebDriver driver) { return new DuckDuckGoSearchResultsPage(driver); }

    //Expedia Page Objects
    public static ExpediaHomePage getExpediaHomePage (WebDriver driver){ return new ExpediaHomePage(driver); }
    public static ExpediaSearchResultsPage getExpediaSearchResultsPage (WebDriver driver){ return new ExpediaSearchResultsPage(driver); }

}
