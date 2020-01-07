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

    @Given("user is on the login page and page title is {string}")
    public void user_is_on_the_login_page_and_page_title_is(String string) {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals(string, Driver.get().getTitle());
        System.out.println(Driver.get().getTitle());

    }

    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        loginPage.login(string,string2);
        System.out.println("Login with "+string+" username and "+string2+" password.");
    }

    @Then("user verifies that {string}  is page title is displayed")
    public void user_verifies_that_is_page_title_is_displayed(String string) {
        BrowserUtils.waitForPageTitle(string);
        Assert.assertEquals(string, Driver.get().getTitle());
        System.out.println(Driver.get().getTitle());

    }


}