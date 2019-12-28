Feature: Crm
  As user, I want to create a pipeline


  Background: User should be on the CRM page
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user logs in as events "crm_manager"
    And user able to navigate "CRM" module
    Then  "Pipeline" title is displayed

  @Crm
  Scenario:Scenario: Login as events crm manager

    Then user able to click "Create" submodule
    And user should open a page that has "Create an Opportunity" text
    Then enter  on Opprtunity Title,Customer,Expected Revenue
                |Opprtunity Title| booook |
                |Customer        |aliy    |
                |Expected Revenue| 500000 |

  @MyPipeLine
  Scenario: User should use My Pipeline filter and remove it
    Given User should see "My Pipeline" as filter
    Then Listed opportunities must belongs to user
    And user can remove the filter by pushing cross
