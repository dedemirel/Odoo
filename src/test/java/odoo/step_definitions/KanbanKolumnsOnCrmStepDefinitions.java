package odoo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import odoo.utilities.Pages;
import org.junit.Assert;
import org.junit.rules.Verifier;

import java.util.Map;

public class KanbanKolumnsOnCrmStepDefinitions {
    private Pages page = new Pages();


    @Given("User should see {int} column")
    public void user_should_see_column(Integer int1) {
        Assert.assertTrue(page.crmPage.listOfKanbanColumns.size()==int1);

    }

    @And("user holds and moves {string} Opportunity to {int} column")
    public void userHoldsAndMovesOpportunityToColumn(String opportunityName, int num) {
        page.crmPage.dragAndDrop(page.crmPage.opportunitiyLocator(opportunityName), page.crmPage.kanbanColumnElement(num));

    }

    @Then("user verify that {string} opportunity is on the kanban Column {int}")
    public void userVerifyThatOpportunityIsOnTheKanbanColumn(String opportunityName, int num){
        Assert.assertTrue("The target column does not have object that you want to move",page.crmPage.correctionOfColumnOfOpportunities(num,opportunityName));
    }


    @Then("send keys below")
    public void sendKeysBelow(Map<String,String> dataTable) {
        page.crt.createTo(dataTable.get("Opprtunity Title"),dataTable.get("Customer"),dataTable.get("Expected Revenue"));
    }

    @Given("There shouldn't be anyOpportunity by the sameName")
    public void thereShouldnTBeAnyOpportunityByTheSameName() {
        Assert.assertTrue(page.crmPage.cleanDragAndDropTest());
    }
}
