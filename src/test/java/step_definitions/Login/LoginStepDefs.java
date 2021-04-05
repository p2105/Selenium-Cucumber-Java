package step_definitions.Login;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseStepDefinition;

/**
 * The type Login step defs.
 */
public class LoginStepDefs {

    private final WebDriver driver;

    /**
     * Instantiates a new Login step defs.
     *
     * @param baseStepDefinition the base step definition
     */
    public LoginStepDefs(BaseStepDefinition baseStepDefinition) {
        driver = baseStepDefinition.getDriver();
    }


    /**
     * Enter user credentials.
     *
     * @param userId the user id
     * @param pwd    the pwd
     */
    @When("he enters the {string} and {string}")
    public void userEntersCredentials(String userId, String pwd) {
        PageObjectManager.getLoginFlow(driver).flowLoginCyclos(userId, pwd);
    }

    /**
     * User login result could be SUCCESSFUL or UNSUCCESSFUL in the scenario.
     *
     * @param loginResult the login result
     */
    @Then("login should be {string}")
    public void userLoginResult(String loginResult) {
        if (loginResult.toUpperCase().equals("UNSUCCESSFUL")) {
            if (PageObjectManager.getLoginPage(driver).isLoginUnsuccessful()) {
                System.out.println("Login Unsuccessful");
            } else {
                throw new RuntimeException("Login is not unsuccessful");
            }
        } else if (loginResult.toUpperCase().equals("SUCCESSFUL")) {
            if (PageObjectManager.getLoginPage(driver).isLoginSuccessful()) {
                System.out.println("Login Successful");
            } else {
                throw new RuntimeException("Login is not successful");
            }
        } else {
            throw new RuntimeException("Pls enter the keyword SUCCESSFUL or UNSUCCESSFUL in the scenario outline");
        }
    }
}
