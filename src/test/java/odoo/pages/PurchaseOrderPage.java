package odoo.pages;

import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PurchaseOrderPage extends BasePage {

    @FindBy(linkText = "Discuss")
    public WebElement pageSubTitle;
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
    @FindBy(xpath = "//ul[starts-with(@id,'ui-id-')]//a[text()='ACD (copy), Moogii']")
    public WebElement vendorList;
    @FindBy(linkText = "Add an item")
    public WebElement addAnItem;
    @FindBy(css = "td[class='o_data_cell o_required_modifier']")
    public WebElement productDropdown;
    @FindBy(xpath = "//ul[starts-with(@id,'ui-id-')]//a[text()='[///] iphone 8']")
    public WebElement productName;
    @FindBy(xpath = ".tab-pane active textarea")
    public WebElement defineCondition;



    public PurchaseOrderPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }
    /**
     * @return page name, for example: Purchases
     */

    public void navigateTo() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(moduleLocator).click().perform();
    }
    public String getPageSubTitle1() {
        //ant time we are verifying page name, or page subtitle=Requests for Quotation
        BrowserUtils.wait(2);
        return pageSubTitle1.getText();
    }
    public void clickToPurchaseOrders() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(purchaseOrdersButton).click().perform();
    }
    public String getPageSubTitle2() {
        //ant time we are verifying page name, or page subtitle=Purchases Order
        BrowserUtils.wait(4);
        return pageSubTitle2.getText();
    }
    public void clickToCreate() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(createButton).click().perform();
    }
    public String getPageSubTitle3() {
        //ant time we are verifying page name, or page subtitle=Purchases Order
        BrowserUtils.wait(2);
        return pageSubTitle3.getText();
    }

    public void clickToVendorButton() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(vendorDropdown).click().perform();

    }
    public void selectToVendor() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(vendorList).click().perform();
        BrowserUtils.wait(2);
    }
    public void addAnItem() {
        BrowserUtils.wait(2);
        Actions action = new Actions(Driver.get());
        action.moveToElement(addAnItem).click().perform();
    }
    public void productDropdown(){
        BrowserUtils.wait(2);
        Actions action1 = new Actions(Driver.get());
        action1.moveToElement(productDropdown).click().perform();
        BrowserUtils.wait(2);
    }
    public void productName(){
        BrowserUtils.wait(2);
        Actions action1 = new Actions(Driver.get());
        action1.moveToElement(productName).click().perform();

    }
    /*public void defineCondition() {
        BrowserUtils.wait(2);
        defineCondition.sendKeys("Imitation phone", Keys.ENTER);
        BrowserUtils.wait(2);
    }*/
}

