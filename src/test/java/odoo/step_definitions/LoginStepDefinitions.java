package odoo.step_definitions;

import odoo.pages.LoginPage;
import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefinitions {
    // Write code here that turns the phrase above into concrete actions
    LoginPage loginPage = new LoginPage();//created login page object

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user logs in as POS manager")
    public void user_logs_in_as_POS_manager() {
        System.out.println("Login as events POS manager");
        //we read username and password from properties file
        //usually in java we use camel case for naming variables
        String userName = ConfigurationReader.getProperty("pos_manager");
        String password = ConfigurationReader.getProperty("pos_manager_password");
        loginPage.login(userName, password);
    }
    @Then("user logs in as events manager")
    public void userLogsInAsEvents(String credentialName) {

        //we read username and password from properties file
        String userName = ConfigurationReader.getProperty(credentialName);
        String password = ConfigurationReader.getProperty(credentialName + "_password");
        //passwords will be stored as (credential_name_password)
        loginPage.login(userName, password);
    }

    //any string in "word" will become a parameter for step definition method
    //  And user verifies that "Discuss" page subtitle is displayed
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String string) {

        Assert.assertEquals(string, loginPage.getPageSubTitle());
        System.out.println("Verifying page subtitle: " + string);
    }

}