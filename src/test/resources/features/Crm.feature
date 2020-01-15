Feature: User should be able to use create,delete, drag&drop opportunities and filter table features on CRM page

  Background: User should be on the CRM page

    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "eventscrmmanager49@info.com" username and "eventscrmmanager" password
    And user able to navigate "CRM" module
    Then  "Pipeline" title is displayed

  @Crm
  Scenario:user should be able to create opportunity
    Given There shouldn't be any opportunity named "booook"
    Then user able to click "Create" submodule
    And user should open a page that has "Create an Opportunity" text
    When enter  on Opprtunity Title,Customer,Expected Revenue
                |Opprtunity Title| booook |
                |Customer        |aliy    |
                |Expected Revenue| 500000 |
    Then user should see new opportunity named "booook"

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

  @KanbanKolumns
  Scenario: User should move opporunity on kanban
    Given There shouldn't be any opportunity named "DragAndDropTest"
    Then user able to click "Create" submodule
    And user should open a page that has "Create an Opportunity" text
    Then send keys below
      |Opprtunity Title| DragAndDropTest |
      |Customer        | NoCustomerTest  |
      |Expected Revenue| 000000000000000 |
     And user holds and moves "DragAndDropTest" Opportunity to 3 column
    Then user verify that "DragAndDropTest" opportunity is on the kanban Column 3

  @DeleteOpportuntiy
  Scenario: User should be able to delete opportunity
    Given There should be DragAndDropTest "DeleteThistest" created
    And user clicks drop-down menu on "DeleteThistest"
    When opened menu clicks delete "DeleteThistest" and ok
    Then "DeleteThistest" has been deleted


