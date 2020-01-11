package odoo.pages;

import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    @FindBy(css = "[data-menu=\"68\"]")
    public WebElement contacts;

    @FindBy(css = "a[class='oe_menu_leaf']")
    public WebElement pageSubTitle;

    @FindBy(css = ".oe_topbar_name")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    @FindBy(css = "div[class = 'o_loading']")
    public WebElement loaderMask;

    @FindBy(css = "[accesskey=\"c\"]")
    public WebElement create;

    @FindBy(xpath = "//*[normalize-space()='CRM' and @class=\"oe_menu_text\"]")
    public WebElement Crm;

    @FindBy(css = (".o_loading[style ='display: none;']"))
    public WebElement pageBlockageNone;

    @FindBy(xpath = "//*[@class=\"active\"and text()='Pipeline']")
    public WebElement pipeline;


    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle(WebElement element) {
        //ant time we are verifying page name, or page subtitle
        BrowserUtils.wait(2);
        BrowserUtils.waitForStaleElement(element);

        return element.getText();
    }

    public void waitForPageBlockage(){
        // this method created for using for finish of the page blockage.
        // it targeted the text of style attribute in the blockage WebElement
        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
        wait.until(ExpectedConditions.attributeToBe(loaderMask,"style","display: none;"));

    }

    public boolean waitUntilLoaderMaskDisappear() {

        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".o_loading[style ='display: none;']")));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true; // no loader mask, all good, return true
        } catch (WebDriverException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void navigateTo(String module) {

        WebElement Module = Driver.get().findElement(By.xpath("//*[normalize-space()='" + module + "' and @class=" +
                "\"oe_menu_text\"]"));

        BrowserUtils.waitForClickablility(Module, 10);
        Module.click();
    }

    public void dragAndDrop(String element1_locatorXpath, String element2_locatorXpath) {
        Actions action = new Actions(Driver.get());
        BrowserUtils.waitForPresence(element1_locatorXpath, 20);
        WebElement element1 = Driver.get().findElement(By.xpath(element1_locatorXpath));
        WebElement element2 = Driver.get().findElement(By.cssSelector(element2_locatorXpath));

        action.dragAndDrop(element1, element2).perform();

    }

}
