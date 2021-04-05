package pagefactory.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Log;
import support.WebElementHelperMethods;

/**
 * This the Cyclos Login Page Object and contains all the methods belonging to it.
 */

public class LoginPage extends WebElementHelperMethods {

    private final By lnkLoginCss = new By.ByCssSelector("#login-link");
    private final By txtUserNameCss = new By.ByCssSelector("[formcontrolname='principal']");
    private final By txtPasswordCss = new By.ByCssSelector("[type='password']");
    private final By btnSubmitCss = new By.ByCssSelector(".btn.d-flex.justify-content-center.align-items-center.w-100.h-100.btn-primary");
    private final By lnkForgotPasswordCss = new By.ByCssSelector("#forgotPasswordLink");
    private final By lnkRegisterANewUserCss = new By.ByCssSelector("registerLink");
    private final By divLoginUnsuccessfulMessage = new By.ByXPath("//*[text()='The given name / password are incorrect. Please, try again.']");
    private final By btnCloseUnsuccessfulLoginMessageNotification = new By.ByCssSelector(".close");
    private final By lnkBanking = new By.ByCssSelector("#menu_banking");

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * Launch cyclos.
     *
     * @param url the url
     */
    public void launchCyclos(String url){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        driver.navigate().to(url);
        Log.debug("Waiting for Page Load");
        waitForPageLoad();
        waitForElement(lnkLoginCss);
        if(!isElementVisible(lnkLoginCss)){
            Log.error("Page has not been loaded correctly");
            throw new RuntimeException("Page has not been loaded correctly");
        }
        driver.manage().window().maximize();
        clickElement(lnkLoginCss);
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Login to cyclos.
     *
     * @param userId the user id
     * @param pwd    the pwd
     */
    public void loginToCyclos(String userId, String pwd){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        Log.debug("Entering Credentials " + userId + " " + pwd);
        setText(txtUserNameCss, userId);
        setText(txtPasswordCss, pwd);
        clickElement(btnSubmitCss);
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click forgot password.
     */
    public void clickForgotPassword(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(lnkForgotPasswordCss);
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Click register new user.
     */
    public void clickRegisterNewUser(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        clickElement(lnkRegisterANewUserCss);
        Log.info("Exiting function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
    }

    /**
     * Is login unsuccessful boolean.
     *
     * @return the boolean
     */
    public boolean isLoginUnsuccessful(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(divLoginUnsuccessfulMessage);
        if(isElementVisible(divLoginUnsuccessfulMessage)){
            highlightElement(driver.findElement(divLoginUnsuccessfulMessage));
            Log.info("Exiting function by returning true - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return true;
        }
        else{
            Log.info("Exiting function by returning false - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return false;
        }
    }

    /**
     * Is login successful boolean.
     *
     * @return the boolean
     */
    public boolean isLoginSuccessful(){
        Log.info("Inside function - " + new Throwable().getStackTrace()[0].getMethodName());
        waitForElement(lnkBanking);
        if(isElementVisible(lnkBanking)){
            highlightElement(driver.findElement(lnkBanking));
            Log.info("Exiting function by returning true - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return true;
        }
        else{
            Log.info("Exiting function by returning false - " + new Throwable().getStackTrace()[0].getClassName() + "-" + new Throwable().getStackTrace()[0].getMethodName());
            return false;
        }
    }
}
