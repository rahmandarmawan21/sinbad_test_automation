@main
Feature: Purchasing Pillow usingCredit Card as payment method

  @tag1
  Scenario: Pay CC Success
    Given Open the Chrome and launch the application "https://demo.midtrans.com/"
    And Click button buy now
    And Click button checkout continue
    When payment credit card
    And Input card number "4811111111111114" with expired date "02/20" with cvv number "123"
    And Input otp bank "112233"
    Then Success Credit Card Payment

  @tag2
  Scenario: Pay CC Failed
    Given Open the Chrome and launch the application "https://demo.midtrans.com/"
    And Click button buy now
    And Click button checkout continue
    When payment credit card
    And Input card number "4911111111111113" with expired date "02/20" with cvv number "123"
    And Input otp bank "112233"
    Then Success Credit Card Payment