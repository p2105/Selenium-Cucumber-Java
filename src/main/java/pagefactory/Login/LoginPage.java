package pagefactory.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.WebElementHelperMethods;

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

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void launchCyclos(String url){
        driver.navigate().to(url);
        waitForPageLoad();
        waitForElement(lnkLoginCss);
        if(!isElementVisible(lnkLoginCss)) throw new RuntimeException("Page has not been loaded correctly");
        driver.manage().window().maximize();
        clickElement(lnkLoginCss);
    }

    public void loginToCyclos(String userId, String pwd){
        setText(txtUserNameCss, userId);
        setText(txtPasswordCss, pwd);
        clickElement(btnSubmitCss);
    }

    public void clickForgotPassword(){
        clickElement(lnkForgotPasswordCss);
    }

    public void clickRegisterNewUser(){
        clickElement(lnkRegisterANewUserCss);
    }

    public boolean loginUnsuccessful(){
        waitForElement(divLoginUnsuccessfulMessage);
        if(isElementVisible(divLoginUnsuccessfulMessage)){
            highlightElement(driver.findElement(divLoginUnsuccessfulMessage));
            return true;
        }
        else{return false;}
    }

    public boolean loginSuccessful(){
        waitForElement(lnkBanking);
        if(isElementVisible(lnkBanking)){
            highlightElement(driver.findElement(lnkBanking));
            return true;
        }
        else{return false;}
    }
}
