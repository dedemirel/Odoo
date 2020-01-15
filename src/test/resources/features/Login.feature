Feature: Login
  As user, I want to be able to login into odoo with role

  @login_with_role_ddt
  Scenario Outline: DDT example, Login as <role>
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user logs in as "<role>"
    And user verifies that "#Inbox - Odoo"  is page title is displayed

    Examples: roles
      | role        |
      | crm manager |
      | pos manager |

  @login_with_credentials_ddt
  Scenario Outline: DDT example, Login as <role>
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "<username>" username and "<password>" password
    And user verifies that "#Inbox - Odoo"  is page title is displayed

    Examples: roles
      | role        | username                    | password              |
      | crm manager | eventscrmmanager49@info.com | eventscrmmanager      |
      | pos manager | posmanager55@info.com       | posmanager            |




