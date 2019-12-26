Feature: Crm
  As user, I want to create a pipeline
@Crm
  Scenario:Scenario: Login as events crm manager
    Given user is on the login page
    Then user logs in as events crm manager
And use able to navigate "CRM" module
    Then  "Pipeline" title is displayed
    Then user able to click "Create" submodule
And user should open a page that has "Create an Opportunity" text
  Then enter  on Opprtunity Title,Customer,Expected Revenue
  |Opprtunity Title| booook |
  |Customer        |aliy    |
  |Expected Revenue| 500000 |

