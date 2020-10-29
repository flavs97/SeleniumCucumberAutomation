#Author: Flaviane C. Siqueira

Feature: Test 2 UI

  @teste2
  Scenario: Buy a product
    Given open url - Demo Store
    When search for product "Shirt"
    And click on product
    And add to cart
    And go to cart
    Then Valid product and price
    When proceed to checkout
    And fill in additional information
    And select and fill payment methods
    And accept the terms and click on the captcha
    And Finalize order
    Then Valid if purchase completed successfully
