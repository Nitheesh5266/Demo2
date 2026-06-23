Feature: SauceDemo Login, Add to Cart, and Logout

  As a registered user of SauceDemo
  I want to log in, add items to my cart, and log out
  So that I can verify the core shopping flow works correctly

  Scenario: Login, add items to cart, and logout successfully
    Given the user is on the SauceDemo login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the products page
    When the user adds the following items to the cart:
      | Sauce Labs Backpack    |
      | Sauce Labs Bike Light  |
    Then the cart badge should show "1" items
    When the user opens the cart page
    Then the cart page should display the following items:
      | Sauce Labs Backpack    |
      | Sauce Labs Bike Light  |
    When the user logs out
    Then the user should be redirected to the login page