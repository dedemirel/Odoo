package odoo.pages;


import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import odoo.utilities.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Utilities;
import java.util.List;

public class CrmPage extends BasePage {

    @FindBy(xpath = "//*[normalize-space()='Create' and @type='button']")
    public WebElement createButton;

    @FindBy(css = ".o_facet_values")
    public WebElement SelectedFilter;

    @FindBy(css = "div[class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement removeFilter;

    public CrmPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    public boolean checkListSize(String userName){

        List<WebElement>pipeLinesOwners = Driver.get().findElements(By.cssSelector(".oe_kanban_content img[title = '"+userName+"']"));
        List<WebElement>pipeLines = Driver.get().findElements(By.cssSelector(".oe_kanban_content img"));

        return pipeLines.size() == pipeLinesOwners.size();
    }
    public boolean userSize(){
        List<WebElement>pipeLines = Driver.get().findElements(By.cssSelector(".oe_kanban_content img"));
        return pipeLines.size() > 1;
    }

  /*  public static void main(String[] args){
        Pages page = new Pages();
        Driver.get().get(ConfigurationReader.getProperty("url"));

        String userName = ConfigurationReader.getProperty("crm_manager");
        String password = ConfigurationReader.getProperty("crm_manager"+"_password");

        page.loginPage.login(userName, password);


        page.loginPage.navigateTo("CRM");
        BrowserUtils.waitForVisibility(page.crmPage.SelectedFilter, 10);
        String userName1 = page.loginPage.userName.getText();

        System.out.println(Driver.get().findElements(By.cssSelector(".oe_kanban_content img[title = '"+userName1+"']")).size());
        System.out.println(Driver.get().findElements(By.cssSelector(".oe_kanban_content img")).size());
    }*/


}

