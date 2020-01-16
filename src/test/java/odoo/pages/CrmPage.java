package odoo.pages;


import odoo.utilities.BrowserUtils;
import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import odoo.utilities.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CrmPage extends BasePage {
    @FindBy(css = "[class *='o_kanban_group ']")
    public List<WebElement> listOfKanbanColumns;

    @FindBy(css = " [class *='o_kanban_group u' ]>div[modifiers]:nth-child(2)")
    public WebElement opportunityElement;// it gives the first element in the first kanban kolumn wich is not empty

    @FindBy(xpath = "//*[normalize-space()='Create' and @type='button']")
    public WebElement createButton;

    @FindBy(css = ".o_facet_values")
    public WebElement SelectedFilter;

    @FindBy(css = "div[class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement removeFilter;

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

    private Actions move = new Actions(Driver.get());

    public CrmPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public String opportunitiyLocator(String nameOfOpportunity){// we can find the opportunity element by text

         return "//*[text() = '" + nameOfOpportunity + "']/parent::node()/parent::node()/parent::node()";

    }
    public boolean PresenceOfOpportunity(String nameOfOpportunity){// if not exist returns true
        String opportunityXpath = opportunitiyLocator(nameOfOpportunity);
        BrowserUtils.waitForPresence(opportunityXpath,5);
        WebElement opportunityWebElement = Driver.get().findElement(By.xpath(opportunityXpath));
        return opportunityWebElement.isDisplayed();
    }


    public boolean notPresenceOfOpportunity(String nameOfOpportunity){// if not exist returns true
        try {
            return BrowserUtils.waitForInVisibility(opportunitiyLocator(nameOfOpportunity), 2);
        }catch (TimeoutException e){
            return false;
        }
    }


    public boolean checkListSize(String userName){

        List<WebElement>pipeLinesOwners = Driver.get().findElements(By.cssSelector(".oe_kanban_content img[title = '"+userName+"']"));
        List<WebElement>pipeLines = Driver.get().findElements(By.cssSelector(".oe_kanban_content img"));

        return pipeLines.size() == pipeLinesOwners.size();
    }


    public boolean userOpportunityListSize(){
        List<WebElement>pipeLines = Driver.get().findElements(By.cssSelector(".oe_kanban_content img"));
        return pipeLines.size() > 1;
    }


    public String kanbanColumnElement(int num){

        return "[class *='o_kanban_group u' ]:nth-of-type("+ num +")";
    }

    public boolean cleanKanbanTable(String opportunityName){
        if(!notPresenceOfOpportunity(opportunityName)) {

            while (!notPresenceOfOpportunity(opportunityName)) {

                openDropDownMenuOnOpprtunities(opportunityName);
                deleteOpportunity(opportunityName);

                BrowserUtils.waitForPresence(opportunitiyLocator(opportunityName), 2);
            }
        }
        return notPresenceOfOpportunity(opportunityName);
    }


    public boolean correctionOfColumnOfOpportunities(int expectedColumnNumber, String nameOfOpportunity){

        String opportunity = opportunitiyLocator(nameOfOpportunity);
        BrowserUtils.waitForPresence(opportunity,10);
        WebElement columnExpected = Driver.get().findElement(By.cssSelector(kanbanColumnElement(expectedColumnNumber)));
        WebElement columnActual = Driver.get().findElement(By.xpath(opportunity+"/parent::node()/parent::node()"));
        boolean result =  columnActual.hashCode() == columnExpected.hashCode();
        return result;
    }


    public boolean openDropDownMenuOnOpprtunities(String opportunityName){
        move.moveToElement(Driver.get().findElement(By.xpath("//*[text() = '"+opportunityName+"']/parent::node()/parent::node()/parent::node()/parent::node()/div"))).click().perform();
        return true;
    }

    public void deleteOpportunity(String opportunityName){

        Driver.get().findElement(By.xpath("//*[text() = '"+opportunityName+"']/parent::node()/parent::node()/parent::node()/parent::node()/div/ul/li[2]/a[text()='Delete']")).click();
        String okButton = "//span[text()='Ok']";
        BrowserUtils.waitForPresence(okButton,10);
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(okButton)),10);
        Driver.get().findElement(By.xpath(okButton+"/parent::node()")).click();

    }
    

}

