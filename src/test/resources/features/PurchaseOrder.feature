Feature: Purchase Orders
  As a POS Manager, I should be able to create purchase orders...

  @PurchaseOrder
  Scenario: Test to create purchase orders
    Given user is on the login page
    Then user logs in as POS manager
    And user verifies that "Discuss" page subtitle is displayed
    Then user should be able to navigate to "Purchases" page
    And user verify that Requests for Quotation subtitle is displayed
    Then user click to Purchase Orders button
    And user verifies that Purchase Orders page subtitle is displayed
    Then user click create button
    And user verifies that page New subtitle is displayed
    Then user click to vendor dropdown button
    And user select the vendor
    Then user click the Add an item button
    And user click to product dropdown button
    Then user select the product
    #And user define terms and conditions

