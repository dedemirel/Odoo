package odoo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import odoo.utilities.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Map;

public class CrmStepDefinitions {



    /* I create the objects on pages class under utils
     so we don't need to create so much objets on all step definition pages. We can add
     our page objects under the pages class and call them by creating only one objects in
     this page def. classes*/

    Pages page = new Pages();

    @And("user able to navigate {string} module")
    public void userAbleToNavigateModule(String module) {

        BrowserUtils.waitForPageToLoad(10);

        page.loginPage.navigateTo(module);


    }

    @Then("{string} title is displayed")
    public void title_is_displayed(String string) {

        BrowserUtils.waitForVisibility(page.loginPage.pipeline, 10);
        page.loginPage.getPageSubTitle(page.loginPage.pipeline);
    }

    @Then("user able to click {string} submodule")
    public void user_able_to_click_submodule(String string) {

        page.crmPage.createButton.click();

    }

    @Then("user should open a page that has {string} text")
    public void user_should_open_a_page_that_has_text(String expectedPageTitle) {

        BrowserUtils.waitForPresence("//*[normalize-space()='Create an Opportunity' and @class=\"modal-title\"]",10);
        WebElement text=Driver.get().findElement(By.xpath("//*[normalize-space()='Create an Opportunity' and @class=\"modal-title\"]"));
        Assert.assertEquals(expectedPageTitle ,text.getText());
    }

    @Then("enter  on Opprtunity Title,Customer,Expected Revenue")
    public void enter_on_Opprtunity_Title_Customer_Expected_Revenue(Map<String,String> dataTable) {

        page.crt.createTo(dataTable.get("Opprtunity Title"),dataTable.get("Customer"),dataTable.get("Expected Revenue"));
page.crt.draganddrop();
    }

    @Given("User should see {string} as filter")
    public void userShouldSeeAsFilter(String MyPipeline) {

        Assert.assertEquals(page.crmPage.SelectedFilter.getText(), MyPipeline);
    }

    @Then("Listed opportunities must belongs to user")
    public void listedOpportunitiesMustBelongsTo() {

        String userName = page.crmPage.userName.getText();
        Assert.assertTrue("There must be much more Opportunities wich belong another user",page.crmPage.checkListSize(userName));
    }


    @And("user can remove the filter by pushing cross")
    public void userCanRemoveTheFilterByPushingCross() {

        page.crmPage.removeFilter.click();
        page.loginPage.waitUntilLoaderMaskDisappear();
        Assert.assertTrue("User size is under two", page.crmPage.userSize());
    }
}
