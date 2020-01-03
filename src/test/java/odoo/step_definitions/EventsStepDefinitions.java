package odoo.step_definitions;

import io.cucumber.java.en.Then;
import odoo.pages.EventsPage;
import odoo.utilities.BrowserUtils;
import org.junit.Assert;

public class EventsStepDefinitions {

    EventsPage eventsPage = new EventsPage();

    @Then("number of events on table should be equals to number of records")
    public void number_of_events_on_table_should_be_equals_to_number_of_records() {

        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForVisibility(eventsPage.eventsAmount,10);
        String events = eventsPage.eventsAmount.getText();
        events = events.substring(events.indexOf("-"));
        int amountsOfEvents = eventsPage.eventsAtTable.size();

        Assert.assertTrue(events.contains(""+amountsOfEvents));


    }

}
