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


    @FindBy(xpath = "//*[normalize-space()='Create' and @class=\"btn btn-sm btn-primary\"]")
    public WebElement create;

    @FindBy(xpath = "//*[normalize-space()='Activity Types' and @class='oe_menu_text']")
    public WebElement activityTypes;

    @FindBy(css = "[class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement createActivity;

    @FindBy(css = "[class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement activityName;

    @FindBy(css = "[class='o_input o_field_widget']")
    public WebElement category;

    @FindBy(css = "[name='category']>option")
    public List<WebElement> categoryOptions;

    @FindBy(css = "[class='o_input o_field_widget']>option:nth-of-type(3)")
    public WebElement meetingOption;

    @FindBy(xpath = "//*[@class='o_field_char o_field_widget o_input']")
    public WebElement summary;

    @FindBy(xpath = "//*[@class='o_field_integer o_field_number o_field_widget o_input']")
    public WebElement days;

    @FindBy(css = "[name='next_type_ids']>div>input")
    public WebElement recommendedNextActivities;

    @FindBy(css = "[class='ui-menu-item']>a")
    public WebElement testDemo;

    @FindBy(css = "[class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveForActivity;

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

