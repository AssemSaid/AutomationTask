Feature: Adding items to Cart function

#browser can be changed by changing the value in "" - it can be Chrome, Firefox or IE. Otherwise the test will fail

  Scenario: Cart has correct items and total amount
    Given User is on Landing page using "chrome" browser on "Windows" platform
    When User creates an account
    And User navigates to Women section
    And User adds items to Cart
    Then check Cart has correct items and amount
