Feature: Submit a Review for a Product

  Scenario: Verify user can submit a review for a product
    Given User opens Product Page for product "1"
    When User writes a review with name "John", email "john@example.com", and text "Great product!"
    Then User sees the message "Thank you for your review."