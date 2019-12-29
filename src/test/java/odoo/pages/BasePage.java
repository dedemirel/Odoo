package odoo.pages;

import odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

//everything that is in common among odoo.pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

}
