package odoo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'o_kanban_v')]/div[@modifiers]")
    public List<WebElement> eventsAtTable;

    @FindBy(css = ".o_pager_value")
    public WebElement eventsAmount;


}
