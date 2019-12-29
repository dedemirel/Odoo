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

    @Then("user logs in as POS manager")
    public void user_logs_in_as_POS_manager() {
        System.out.println("Login as events POS manager");

    @Then("user logs in as events {string}")
    public void userLogsInAsEvents(String credentialName) {

        //we read username and password from properties file
        String userName = ConfigurationReader.getProperty(credentialName);
        String password = ConfigurationReader.getProperty(credentialName + "_password");
        //passwords will be stored as (credential_name_password)
        page.loginPage.login(userName, password);
    }

    //any string in "word" will become a parameter for step definition method
    //  And user verifies that "Discuss" page subtitle is displayed
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verifies_that_page_subtitle_is_displayed(String string) {

        Assert.assertEquals(string, loginPage.getPageSubTitle());
        System.out.println("Verifying page subtitle: " + string);

    @And("user verifies that {string}  is page title is displayed")
    public void userVerifiesThatIsPageTitleIsDisplayed(String expectedTitle) {

        BrowserUtils.wait(4);
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());

    }

}
