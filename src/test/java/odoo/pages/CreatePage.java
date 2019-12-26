package odoo.pages;

import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreatePage extends  BasePage {
@FindBy(css = "[placeholder=\"e.g. Customer Deal\"]")
   public WebElement Title;
@FindBy(xpath = "//tbody/tr[2]/td[2]/div/div/input")
public WebElement Customerr;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/div/input")
    public WebElement Revenue;
@FindBy(xpath = "//*[normalize-space()='Create' and @class=\"btn btn-sm btn-primary\"]")
    public WebElement create;

    public CreatePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }
public void createTo(String title,String customer,String revenue){
        Title.sendKeys(title);

        Customerr.sendKeys(customer,Keys.ENTER);
        Revenue.sendKeys(revenue);
create.click();
    }

}
