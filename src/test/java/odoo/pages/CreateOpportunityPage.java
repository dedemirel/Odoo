package odoo.pages;


import odoo.utilities.BrowserUtils;
import odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateOpportunityPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[9]")
    public WebElement createdOpportunity;

    @FindBy(css = "[placeholder=\"e.g. Customer Deal\"]")
    public WebElement Title;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/div/div/input")
    public WebElement Customerr;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/div/input")
    public WebElement Revenue;

    @FindBy(xpath = "//*[normalize-space()='Create' and @class=\"btn btn-sm btn-primary\"]")
    private WebElement create;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public WebElement createOpportunityWindowTitle;

    public CreateOpportunityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void createTo(String title, String customer, String revenue) {
        Title.sendKeys(title);
        Customerr.sendKeys(customer, Keys.ENTER);
        Revenue.clear();
        Revenue.sendKeys(revenue);
        create.click();

    }

    public boolean ifNotcreateOpportunity(String opportunityName){
        CrmPage crm = new CrmPage();
        if (crm.notPresenceOfOpportunity(opportunityName)){
            crm.createButton.click();
            BrowserUtils.waitForVisibility(createOpportunityWindowTitle, 10);
            createTo(opportunityName,"","");
            BrowserUtils.waitForPresence(crm.opportunitiyLocator(opportunityName),20);
        }
        return !crm.notPresenceOfOpportunity(opportunityName);
    }

}
