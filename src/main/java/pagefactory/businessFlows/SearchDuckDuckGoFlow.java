package pagefactory.businessFlows;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

/**
 * This class contains all the reusable flows for DuckDuckGo application.
 */
public class SearchDuckDuckGoFlow extends WebElementHelperMethods {

    /**
     * Instantiates a new SearchDuckDuckGo flow.
     *
     * @param driver the driver
     */
    public SearchDuckDuckGoFlow(WebDriver driver){ super(driver); }

    /**
     * Flow Login DuckDuckGo page and search for a text.
     *
     * @param txtToBeSearched the text to be searched
     * @param url             the url for DuckDuckGo
     */
    public void searchTextInDuckDuckGo(String txtToBeSearched, String url)
    {
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        PageObjectManager.getDuckDuckGoPage(driver).launchDuckDuckGoPage(url);
        PageObjectManager.getDuckDuckGoPage(driver).enterSearchTextAndClickSearch(txtToBeSearched);
        Log.debug("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Match location name from the search text box and the name present in the span on the right side of the page.
     *
     * @param locationNameToBeCompared the location name to be compared
     * @return true if both the span text and textbox text is matching or else false
     */
    public boolean matchLocationName(String locationNameToBeCompared){
        Log.debug("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        String actualApplicationSearchText = PageObjectManager.getDuckDuckGoSearchResultsPage(driver).getSearchBoxText();
        String actualApplicationSpanText = PageObjectManager.getDuckDuckGoSearchResultsPage(driver).getLocationNameFromSpan();
        boolean txtboxSearchResult = locationNameToBeCompared.equalsIgnoreCase(actualApplicationSearchText);
        boolean spanSearchResult = locationNameToBeCompared.contains(actualApplicationSpanText);
        Log.debug("Exiting function returning - " + (txtboxSearchResult || spanSearchResult) + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        return txtboxSearchResult || spanSearchResult;
    }

}
