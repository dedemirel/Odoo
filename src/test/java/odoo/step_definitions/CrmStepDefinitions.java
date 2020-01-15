package odoo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import odoo.utilities.Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Map;

public class CrmStepDefinitions {


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

        BrowserUtils.waitForVisibility(page.crt.createOpportunityWindowTitle, 10);
        Assert.assertEquals(expectedPageTitle, page.crt.createOpportunityWindowTitle.getText());
    }

    @Then("enter  on Opprtunity Title,Customer,Expected Revenue")
    public void enter_on_Opportunity_Title_Customer_Expected_Revenue(Map<String, String> dataTable) {

        page.crt.createTo(dataTable.get("Opprtunity Title"), dataTable.get("Customer"), dataTable.get("Expected Revenue"));

    }

    @Given("User should see {string} as filter")
    public void userShouldSeeAsFilter(String MyPipeline) {

        Assert.assertEquals(page.crmPage.SelectedFilter.getText(), MyPipeline);
    }

    @Then("Listed opportunities must belongs to user")
    public void listedOpportunitiesMustBelongsTo() {

        String userName = page.crmPage.userName.getText();
        Assert.assertTrue("There must be much more Opportunities which belong another user", page.crmPage.checkListSize(userName));
    }


    @And("user can remove the filter by pushing cross")
    public void userCanRemoveTheFilterByPushingCross() {

        page.crmPage.removeFilter.click();
        page.loginPage.waitForPageBlockage();
        Assert.assertTrue("User opportunity list  size is under two", page.crmPage.userOpportunityListSize());
    }

    @And("user clicks drop-down menu on {string}")
    public void userClicksDropDownMenuOn(String oportunityName) {
        page.crmPage.openDropDownMenuOnOpprtunities(oportunityName);
    }

    @When("opened menu clicks delete {string} and ok")
    public void openedMenuClicksDeleteAndOk(String oportunityName) {
        page.crmPage.deleteOpportunity(oportunityName);
    }

    @Then("{string} has been deleted")
    public void hasBeenDeleted(String oportunityName) {
        Assert.assertTrue("Opportunity didn't deleted", page.crmPage.notPresenceOfOpportunity(oportunityName));
    }


    @Given("There should be DragAndDropTest {string} created")
    public void thereShouldBeDragAndDropTestCreated(String oportunityName) {
        Assert.assertTrue(page.crt.ifNotcreateOpportunity(oportunityName));
    }


    @Given("There shouldn't be any opportunity named {string}")
    public void thereShouldnTBeAnyOpportunityNamed(String arg0) {
       page.crmPage.cleanKanbanTable(arg0);
    }

    @Then("user should see new opportunity named {string}")
    public void userShouldSeeNewOpportunityNamed(String arg0) {
        Assert.assertTrue("Thekanban table does not have object that you want to create", page.crmPage.PresenceOfOpportunity(arg0));
        page.crmPage.cleanKanbanTable(arg0);
    }
}
