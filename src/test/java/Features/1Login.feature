Feature: Login
  Scenario: Login to Sauce demo
    Given browser is opened
    And user is on the login page
    And user enters username
    And user enters password
    When user click login button
    Then login is success
    When the user add product labs-backpack
    Then the product is added to cart

    