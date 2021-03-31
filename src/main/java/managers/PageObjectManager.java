package managers;

import businessFlows.LoginFlow;
import org.openqa.selenium.WebDriver;
import pagefactory.*;
import pagefactory.Login.LoginPage;


public class PageObjectManager {



    private static LandingPage landingPage;
    private static LoginPageOld loginPage;
    private static CreateChildTicket createChildTicket;
    private static ChangeStatusOfTicket changeStatusOfTicket;
    private static TicketCreationTab ticketCreationTab;
    private static VisitUrls visitUrls;


    private PageObjectManager()
    {}


    public static LoginFlow getLoginFlow(WebDriver driver){
        return new LoginFlow(driver);
    }

    public static LandingPage getLandingPage(WebDriver driver){
//        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
        return new LandingPage(driver);
    }

    public static LoginPageOld getLoginPageOld(WebDriver driver){

//        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
        return new LoginPageOld(driver);

    }

    public static LoginPage getLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }

    public static TicketCreationTab getTicketCreationTab(WebDriver driver){
//        return (ticketCreationTab == null) ? ticketCreationTab = new TicketCreationTab(driver) : ticketCreationTab;
        return new TicketCreationTab(driver);
    }

    public static CreateChildTicket createChildTicket(WebDriver driver){
//        return (createChildTicket == null) ? createChildTicket = new CreateChildTicket(driver) : createChildTicket;
        return new CreateChildTicket(driver);
    }



}
