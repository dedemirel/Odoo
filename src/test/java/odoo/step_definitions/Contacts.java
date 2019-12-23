package odoo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import odoo.pages.LoginPage;
import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Contacts {

    LoginPage loginPage = new LoginPage();//created login page object





    @Then("user verifies that {string} module is displayed")
    public void user_verifies_that_module_is_displayed(String string) {
 Assert.assertEquals(string,loginPage.getPageSubTitle());
        System.out.println("Verifying page subtitle: " + string);
    }

    @Then("user clicks on {string} module")
    public void user_clicks_on_module(String string) {
loginPage.contacts.click();
        System.out.println("passed");
    }

    @Then("user verifies that {string} submodule is displayed")
    public void user_verifies_that_submodule_is_displayed(String string) {
BrowserUtils.wait(10);
        Assert.assertTrue(loginPage.create.isDisplayed());
        System.out.println("verifies that submodule is displayed as"+ string);
    }





}
