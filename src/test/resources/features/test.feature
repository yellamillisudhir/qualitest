Feature: Launch Katalon Shop

Scenario: Validate items in the shopping cart

Given I add four ramdon items to my cart
When I view my cart
Then I find total four items listed in my cart
When I search for lowest price item
And I am able to remove the lowest price item from my cart
Then I am able to verify the three items in the cart