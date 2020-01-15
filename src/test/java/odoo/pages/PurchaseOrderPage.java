package odoo.pages;

import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Watchable;


public class PurchaseOrderPage extends BasePage {

    @FindBy(linkText = "Purchases")
    public WebElement moduleLocator;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pageSubTitle1;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[9]/ul[1]/li[2]/a/span")
    public WebElement purchaseOrdersButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pageSubTitle2;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public  WebElement createButton;
    @FindBy(css = "span[class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement pageSubTitle3;
    @FindBy(css= "[name='partner_id'] span")
    public WebElement vendorDropdown;
    @FindBy(xpath = "//ul[starts-with(@id,'ui-id-')]/li[5]")
    public WebElement vendorList;
    @FindBy(linkText = "Add an item")
    public WebElement addAnItem;
    @FindBy(css = "td[class='o_data_cell o_required_modifier']")
    public WebElement productDropdown;
    @FindBy(xpath = "//ul[starts-with(@id,'ui-id-')][9]/li[1]")
    public WebElement productName;
    @FindBy(css = ".tab-pane.active>textarea:nth-of-type(1)")
    public WebElement defineCondition;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/button[5]")
    public WebElement confirmButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[1]")
    public WebElement saveButton;
    @FindBy(xpath ="/html/head/title")
   public  WebElement referenceNumber1;
    @FindBy(xpath ="//tbody[starts-with(@class,'ui-sortable')]/tr[1]/td[2]" )
    public WebElement referenceNumber2;


    public PurchaseOrderPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }
    /**
     * @return page name, for example: Purchases
     */

    /*public void navigateTo() {
        Actions action = new Actions(Driver.get());
        action.moveToElement(moduleLocator).click().perform();
    }*/
    public String getPageSubTitle1() {
        //ant time we are verifying page name, or page subtitle=Requests for Quotation
        BrowserUtils.waitForPageTitle("Requests for Quotation - Odoo");
        return Driver.get().getTitle();
    }
    public void clickToPurchaseOrders() {
        BrowserUtils.clickWithWait(purchaseOrdersButton);

    }
    public String getPageSubTitle2() {
        //ant time we are verifying page name, or page subtitle=Purchases Order
        BrowserUtils.waitForPageTitle("Purchase Orders - Odoo");
        return Driver.get().getTitle();
    }
    public void clickToCreate() {
        BrowserUtils.clickWithWait(createButton);
    }
    public String getPageSubTitle3() {
        //ant time we are verifying page name, or page subtitle=Purchases Order
        BrowserUtils.waitForPageTitle("New - Odoo");
        return Driver.get().getTitle();
    }

    public void clickToVendorButton() {
        Actions action = new Actions(Driver.get());
        action.moveToElement(vendorDropdown).click().perform();
    }
    public void selectToVendor() {
        BrowserUtils.waitForClickablility(vendorList,4);
        vendorList.click();
    }
    public void addAnItem() {
        Actions action = new Actions(Driver.get());
        action.moveToElement(addAnItem).click().perform();
        BrowserUtils.waitForClickablility(productDropdown,4);
    }
    public void productDropdown(){
        Actions action = new Actions(Driver.get());
        action.moveToElement(productDropdown).click().perform();
        BrowserUtils.waitForVisibility(productName,4);
    }
    public void productName(){
        Actions action = new Actions(Driver.get());
        action.moveToElement(productName).click().perform();
    }
    public void defineCondition()
    {
        defineCondition.sendKeys("Cakma Tisort", Keys.ENTER);

    }
    public void clickToConfirmButton(){
        Actions action = new Actions(Driver.get());
        action.moveToElement(confirmButton).click().perform();

    }
    public void clickToSaveButton(){
        Actions action = new Actions(Driver.get());
        action.moveToElement(saveButton).click().perform();
    }
}



