package pagefactory.businessFlows;

import com.sun.deploy.Environment;
import managers.FileReaderManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import support.WebElementHelperMethods;

/**
 * This class contains all the reusable flows for Login to Cyclos.
 */
public class LoginFlow extends WebElementHelperMethods {

    /**
     * Instantiates a new Login flow.
     *
     * @param driver the driver
     */
    public LoginFlow(WebDriver driver){
        super(driver);

    }

    /**
     * Flow login cyclos.
     *
     * @param userId the user id
     * @param pwd    the pwd
     */
    public void flowLoginCyclos(String userId, String pwd)
    {
        PageObjectManager.getLoginPage(driver).launchCyclos(getAppUrl());
        PageObjectManager.getLoginPage(driver).loginToCyclos(userId, pwd);
    }

    /**
     * Get app url string.
     *
     * @return the string
     */
    public String getAppUrl(){
        String url = "", env = "";

        try {
                env = Environment.getenv("env").toUpperCase();
        }catch (NullPointerException ignored){env = "QA";}

        switch (env){
            case "QA": case "":
                url = FileReaderManager.getConfigReader().getAppUrl("QA");
                break;
            case "PROD":
                url = FileReaderManager.getConfigReader().getAppUrl("PROD");
                break;
            case "DEV":
                url = FileReaderManager.getConfigReader().getAppUrl("DEV");
                break;
            default:
                throw new RuntimeException("Env " + env + " not specified in the Configuration.properties file.");
        }
        return url;
    }
}
