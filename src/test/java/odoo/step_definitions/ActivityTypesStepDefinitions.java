package odoo.step_definitions;



    import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import odoo.utilities.BrowserUtils;
import odoo.utilities.Pages;
import org.junit.Assert;

import java.util.List;
//

    public class ActivityTypesStepDefinitions {
        //CrmPage crmPage = new CrmPage();
        Pages pages = new Pages();

        @Given("user able to navigate Activity Types page")
        public void user_able_to_navigate_Activity_Types_page() {
            BrowserUtils.waitForClickablility(pages.crmPage.activityTypes,5);
            pages.crmPage.activityTypes.click();
        }


        @Then("user able to click on Create button")
        public void user_able_to_click_on_Create_button() {
            BrowserUtils.waitForClickablility(pages.crmPage.createActivity,5);
            pages.crmPage.createActivity.click();
        }

        @Then("user able to set name {string} on the table")
        public void user_able_to_set_name_on_the_table(String string) {
            BrowserUtils.waitForVisibility(pages.crmPage.activityName,15);
            BrowserUtils.waitForClickablility(pages.crmPage.activityName,10);

            pages.crmPage.activityName.sendKeys(string);
        }

        @Then("user clicks Category")
        public void user_clicks_Category() {
            pages.crmPage.category.click();
        }

        @Then("user able to see two options")
        public void user_able_to_see_two_options(List<String> dataTable) {
            Assert.assertEquals(dataTable, BrowserUtils.getListOfString(pages.crmPage.categoryOptions));
        }

        @Then("user able to select Meeting option")
        public void user_able_to_select_Meeting_option() {
            pages.crmPage.meetingOption.click();
        }

        @Then("user able to write {string} on the Summary section")
        public void user_able_to_write_on_the_Summary_section(String string) {
            pages.crmPage.summary.clear();
            pages.crmPage.summary.sendKeys(string);
        }

        @Then("user able to write {string} on the Days section")
        public void user_able_to_write_on_the_Days_section(String string) {
            pages.crmPage.days.clear();
            pages.crmPage.days.sendKeys(string);
        }

        @Then("user clicks Recommended Next Activities")
        public void user_clicks_Recommended_Next_Activities() {
            pages.crmPage.recommendedNextActivities.click();
        }

        @Then("user able to select for select TestDemo option")
        public void user_able_to_select_for_select_TestDemo_option() {
            BrowserUtils.waitForClickablility(pages.crmPage.testDemo,5);
            pages.crmPage.testDemo.click();
        }

        @Then("user able to save table.")
        public void user_able_to_save_table() {
            BrowserUtils.waitForClickablility(pages.crmPage.saveForActivity,10);
            pages.crmPage.saveForActivity.click();
        }

    }

