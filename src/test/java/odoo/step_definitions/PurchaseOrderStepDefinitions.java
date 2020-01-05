package odoo.step_definitions;

import io.cucumber.java.en.*;
import odoo.pages.LoginPage;
import odoo.pages.PurchaseOrderPage;
import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import org.junit.Assert;

public class PurchaseOrderStepDefinitions {
    PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage();


    @Then("user should be able to navigate to {string} page")
    public void user_should_be_able_to_navigate_to_page(String string) {
        purchaseOrderPage.navigateTo(string);
    }

    @Then("user verify that {string} subtitle is displayed")
    public void user_verify_that_Request_for_Quotation_subtitle_is_displayed(String string) {
        Assert.assertEquals(string, purchaseOrderPage.getPageSubTitle1());
        System.out.println("Verifying page subtitle: "+string);
    }
    @Then("user click to {string} button")
    public void user_click_to_Purchase_Orders_button(String string) {
        purchaseOrderPage.clickToPurchaseOrders();
        System.out.println("user click to "+string+" button");

    }
    @Then("user verifies that {string} page subtitle is displayed")
    public void user_verify_that_Purchase_Order_subtitle_is_displayed(String string) {

        Assert.assertEquals(string, purchaseOrderPage.getPageSubTitle2());
        System.out.println("Verifying page subtitle: "+string);
    }
    @Then("user click create button")
    public void user_click_create_button() {
        purchaseOrderPage.clickToCreate();
    }

    @Then("user verifies that page {string} subtitle is displayed")
    public void user_verifies_that_page_New_subtitle_is_displayed(String string) {

        Assert.assertEquals(string, purchaseOrderPage.getPageSubTitle3());
        System.out.println("Verifying page subtitle: "+string);
    }

    @Then("user click to vendor dropdown button")
    public void user_click_to_vendor_button() {
        purchaseOrderPage.clickToVendorButton();

    }
    @Then("user select the vendor")
    public void user_select_the_vendor() {
        purchaseOrderPage.selectToVendor();

    }
    @Then("user click the {string} button")
    public void user_click_the_Add_an_item_button(String string) {
        purchaseOrderPage.addAnItem();

    }

    @Then("user click to product dropdown button")
    public void user_click_to_product_dropdown_button() {
        purchaseOrderPage.productDropdown();

    }

    @Then("user select the product")
    public void user_select_the_product() {
        purchaseOrderPage.productName();

    }
    @Then("user define terms and conditions")
    public void user_define_terms_and_conditions() {
        purchaseOrderPage.defineCondition();

    }
    @Then("user click the confirm button")
    public void user_click_the_confirm_button() {
        purchaseOrderPage.clickToConfirmButton();

    }

    @Then("user click the save button")
    public void user_click_the_save_button() {
        System.out.println("Verifying that purchase order is "+ Driver.get().getTitle());
        purchaseOrderPage.clickToSaveButton();

    }
    @Then("user click to {string} button again")
    public void user_click_to_Purchase_Orders_button_again(String string) {
        purchaseOrderPage.clickToPurchaseOrders();
        System.out.println("user click to "+string+" button again");
    }
    @Then("user verify that selected product is on the page")
    public void user_verify_that_selected_product_is_on_the_page() {

        System.out.println("Verifying that purchase order is "+ purchaseOrderPage.referenceNumber2.getText());

    }

}
