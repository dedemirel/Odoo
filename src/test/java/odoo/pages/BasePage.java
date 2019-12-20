package odoo.pages;

import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//everything that is in common among odoo.pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {

    @FindBy(css = "a[class='oe_menu_leaf']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }
    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle
        BrowserUtils.wait(2);
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }

}