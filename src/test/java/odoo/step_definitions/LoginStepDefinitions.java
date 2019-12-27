package odoo.step_definitions;

import odoo.pages.LoginPage;
import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import io.cucumber.java.en.*;
import odoo.utilities.Pages;
import org.junit.Assert;

public class LoginStepDefinitions {

    Pages page = new Pages();


    @Given("user is on the login page and page title is {string}")
    public void userIsOnTheLoginPageAndPageTitleIs(String expectedTitle) {

        Driver.get().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @Then("user logs in as events {string}")
    public void userLogsInAsEvents(String credentialName) {

        //we read username and password from properties file
        String userName = ConfigurationReader.getProperty(credentialName);
        String password = ConfigurationReader.getProperty(credentialName+"_password");
        //passwords will be stored as (credential_name_password)
        page.loginPage.login(userName, password);
    }

    @And("user verifies that {string}  is page title is displayed")
    public void userVerifiesThatIsPageTitleIsDisplayed(String expectedTitle) {

        BrowserUtils.wait(4);
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());

    }



}
