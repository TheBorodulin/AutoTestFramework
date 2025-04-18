Feature: Add to Cart

  Scenario: Verify user is able to add product to cart from Homepage
    Given User opens Homepage
    And User add product with number "1" to cart
    Then User sees successful message on confirmation popup