@Events
Feature: Events
  As user I should be able to see Events Page

  Scenario: Verify that page size number match with amount of events
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user logs in as events "crm_manager"
    And user verifies that "#Inbox - Odoo"  is page title is displayed
    And user able to navigate "Events" module
    And number of events on table should be equals to number of records