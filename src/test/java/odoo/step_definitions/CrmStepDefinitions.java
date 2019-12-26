package odoo.step_definitions;

import io.cucumber.java.en.Then;
import odoo.pages.CreatePage;
import odoo.pages.LoginPage;
import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class CrmStepDefinitions {
LoginPage loginPage=new LoginPage();
    CreatePage crt=new CreatePage();
    @Then("use able to navigate {string} module")
    public void use_able_to_navigate_module(String string) {
        loginPage.navigateTo(string);
    }

    @Then("{string} title is displayed")
    public void title_is_displayed(String string) {
        BrowserUtils.wait(5);
        loginPage.getPageSubTitle(loginPage.pipeline);
    }
    @Then("user able to click {string} submodule")
    public void user_able_to_click_submodule(String string) {
 WebElement str=       Driver.get().findElement(By.xpath("//*[normalize-space()='"+string+"' and @type=\"button\"]"));
 str.click();
        System.out.println(str.isDisplayed());
    }
    @Then("user should open a page that has {string} text")
    public void user_should_open_a_page_that_has_text(String string) {
BrowserUtils.wait(5);
        WebElement text=Driver.get().findElement(By.xpath("//*[normalize-space()='Create an Opportunity' and @class=\"modal-title\"]"));
        System.out.println(text.getText());
    }

    @Then("enter  on Opprtunity Title,Customer,Expected Revenue")
    public void enter_on_Opprtunity_Title_Customer_Expected_Revenue(Map<String,String> dataTable) {
crt.createTo(dataTable.get("Opprtunity Title"),dataTable.get("Customer"),dataTable.get("Expected Revenue"));

    }


}
