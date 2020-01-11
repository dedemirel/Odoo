Feature: Crm
  As user, I want to create a pipeline


  Background: User should be on the CRM page
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "eventscrmmanager49@info.com" username and "eventscrmmanager" password
    And user able to navigate "CRM" module
    Then  "Pipeline" title is displayed

  @Crm
  Scenario:Scenario: Login as events crm manager

    Then user able to click "Create" submodule
    And user should open a page that has "Create an Opportunity" text
    Then enter  on Opprtunity Title,Customer,Expected Revenue
                |Opprtunity Title| iphone |
                |Customer        |aliy    |
                |Expected Revenue| 500000 |

  @MyPipeLine
  Scenario: User should use My Pipeline filter and remove it
    Given User should see "My Pipeline" as filter
    Then Listed opportunities must belongs to user
    And user can remove the filter by pushing cross

      @actvity_types
      Scenario: Verify that user able to create an activity
      Given user able to navigate Activity Types page
      Then user able to click on Create button
      And user able to set name "Hasan Oz" on the table
      Then user clicks Category
      And user able to see two options
        |Other  |
        |Meeting|
      Then user able to select Meeting option
      Then user able to write "All CRM Activities" on the Summary section
      Then user able to write "3 days" on the Days section
      And user clicks Recommended Next Activities
      Then user able to select for select TestDemo option
      And user able to save table.

