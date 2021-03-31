package step_definitions.Login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import step_definitions.SharedStepDefinition;

public class LoginStepDefs {

    private WebDriver driver;

    public LoginStepDefs(SharedStepDefinition sharedStepDefinition){
        driver = sharedStepDefinition.getDriver();
    }


    @When("he enters the {string} and {string}")
    public void userEntersCredentials(String userId, String pwd)
    {
        PageObjectManager.getLoginFlow(driver).flowLoginCyclos(userId, pwd);
    }

    @Then("login should be {string}")
    public void userLoginResult(String loginResult) {
        if(loginResult.toUpperCase().equals("UNSUCCESSFUL")){
            PageObjectManager.getLoginPage(driver).loginUnsuccessful();
        }
        else if(loginResult.toUpperCase().equals("SUCCESSFUL")){
            PageObjectManager.getLoginPage(driver).loginSuccessful();
        }
        else{
            throw new RuntimeException("Pls enter the keyword SUCCESSFUL or UNSUCCESSFUL in the scenario outline");
        }
    }
}
