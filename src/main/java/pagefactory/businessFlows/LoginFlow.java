package pagefactory.businessFlows;

import managers.FileReaderManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import support.WebElementHelperMethods;

public class LoginFlow extends WebElementHelperMethods {

    public LoginFlow(WebDriver driver){
        super(driver);

    }

    public void flowLoginCyclos(String userId, String pwd)
    {
        PageObjectManager.getLoginPage(driver).launchCyclos(getAppUrl());
        PageObjectManager.getLoginPage(driver).loginToCyclos(userId, pwd);
    }

    public String getAppUrl(){
        String url = "", env = "";

        try {
                env = System.getProperty("env").toUpperCase();
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
