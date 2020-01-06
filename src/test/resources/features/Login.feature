Feature: Login
  As user, I want to be able to login into odoo with role

  @Login
  Scenario Outline: DDT example, Login as <role>
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "<username>" username and "<password>" password
    And user verifies that "#Inbox - Odoo"  is page title is displayed

    Examples: roles
      | role        | username                    | password              |
      | crm manager | eventscrmmanager49@info.com | eventscrmmanager      |
      | pos manager | posmanager55@info.com       | posmanager            |




