package odoo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "odoo/step_definitions",
        dryRun = false,
        tags = {"@Events","@Login, @PurchaseOrder"},
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class CucumberRunner {


}