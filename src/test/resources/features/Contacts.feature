Feature: Contacts
  As user, I am  able to create a new contact by Contacts.
@Contacts
  Scenario: Login as events crm manager
    Given user is on the login page
    Then user logs in as events crm manager
    And user verifies that "Contacts" module is displayed
    Then user clicks on "Contacts" module
    And user verifies that "Create" submodule is displayed
  



