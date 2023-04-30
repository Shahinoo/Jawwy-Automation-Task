@smoke
Feature: Validate Subscribe feature

  Background: User already on Subscribe page
    Given User on subscribe page

  Scenario Outline: Validate The Mobile Payment Packages Type, Price and Currency
    When User select a "<country>" from countries list
    Then a Classic mobile package is displayed
    And The Currency and the Price of the selected "<country>" are displayed
    When User click on select button
    Then user should be on payment method
    Examples:
      | country  |
      | Egypt    |
      | Emirates |
      | Oman     |

  Scenario Outline: Validate Packages of Credit card payment
    When User select a "<country>" from countries list
    Then The Three types of packages is displayed for credit card
    And validate the prices for all packages in the selected "<country>"
    And Validate the currency for all packages in the selected "<country>"
    When Select free-trial for any listed package
    Then Total price should be zero for any listed "<country>"
    Examples:
      | country  |
      | Egypt    |
      | Emirates |
      | Oman     |
