Feature: Events
  As user I should be able to see Events Page
  Background: User should be on the CRM page
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "eventscrmmanager49@info.com" username and "eventscrmmanager" password
    And user verifies that "#Inbox - Odoo"  is page title is displayed

  @Events
  Scenario: Verify that page size number match with amount of events
    Then user able to navigate "Events" module
    And number of events on table should be equals to number of records