Feature: Login
  As user, I want to be able to login into odoo with username and password

#  Any step that was implemented before, can be reused
#  If test step has yellow background, tat means it doesn't have implementation yet
#  click command/ctrl + option/alt + L to organize code, save like in java
#  I had somewhere from 2 to 25 scenarios in every feature file
#  By passing parameters/strings in "some word" we can reuse test steps
#  In my project, I was trying to keep scenarios short

  @events_crm_manager
  Scenario: Login as events crm manager
    Given user is on the login page
    Then user logs in as events crm manager
    And user verifies that "Discuss" page subtitle is displayed


