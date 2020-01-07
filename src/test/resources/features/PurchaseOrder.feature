Feature: Purchase Orders
  As a POS Manager, I should be able to create purchase orders...
  Background: User is Logged In
    Given user is on the login page and page title is "Login | Best ERP solution for startups"
    Then user enters "posmanager55@info.com" username and "posmanager" password
    And user verifies that "#Inbox - Odoo"  is page title is displayed


  @PurchaseOrder
  Scenario: Test to create purchase orders
    Then user should be able to navigate to "Purchases" page
    And user verify that "Requests for Quotation - Odoo" subtitle is displayed
    Then user click to "Purchase Orders" button
    And user verifies that "Purchase Orders - Odoo" page subtitle is displayed
    Then user click create button
    And user verifies that page "New - Odoo" subtitle is displayed
    Then user click to vendor dropdown button
    And user select the vendor
    Then user click the "Add an item" button
    And user click to product dropdown button
    Then user select the product
    And user define terms and conditions
    Then user click the confirm button
    And user click the save button
    Then user click to "Purchase Orders" button again
    And user verify that selected product is on the page