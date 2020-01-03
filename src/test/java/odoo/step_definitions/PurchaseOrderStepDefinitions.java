package odoo.step_definitions;

import io.cucumber.java.en.*;
import odoo.pages.PurchaseOrderPage;
import org.junit.Assert;

public class PurchaseOrderStepDefinitions {
    PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage();

    @Then("user should be able to navigate to {string} page")
    public void user_should_be_able_to_navigate_to_page(String string) {
        purchaseOrderPage.navigateTo();
    }

    @Then("user verify that Requests for Quotation subtitle is displayed")
    public void user_verify_that_Request_for_Quotation_subtitle_is_displayed() {

        Assert.assertEquals("Requests for Quotation", purchaseOrderPage.getPageSubTitle1());
        System.out.println("Verifying page subtitle: Requests for Quotation");
    }
    @Then("user click to Purchase Orders button")
    public void user_click_to_Purchase_Orders_button() {
        // Write code here that turns the phrase above into concrete actions
        purchaseOrderPage.clickToPurchaseOrders();

    }
    @Then("user verifies that Purchase Orders page subtitle is displayed")
    public void user_verify_that_Purchase_Order_subtitle_is_displayed() {

        Assert.assertEquals("Purchase Orders", purchaseOrderPage.getPageSubTitle2());
        System.out.println("Verifying page subtitle: Purchase Orders");
    }
    @Then("user click create button")
    public void user_click_create_button() {
        purchaseOrderPage.clickToCreate();
    }

    @Then("user verifies that page New subtitle is displayed")
    public void user_verifies_that_page_New_subtitle_is_displayed() {

        Assert.assertEquals("New", purchaseOrderPage.getPageSubTitle3());
        System.out.println("Verifying page subtitle: New");
    }

    @Then("user click to vendor dropdown button")
    public void user_click_to_vendor_button() {
        purchaseOrderPage.clickToVendorButton();

    }
    @Then("user select the vendor")
    public void user_select_the_vendor() {
        purchaseOrderPage.selectToVendor();

    }
    @Then("user click the Add an item button")
    public void user_click_the_Add_an_item_button() {
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
    /*@Then("user define terms and conditions")
    public void user_define_terms_and_conditions() {
        purchaseOrderPage.defineCondition();

    }*/


}
