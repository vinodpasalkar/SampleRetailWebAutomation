Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal


Scenario: Add products to wishList and then to cart and verify the same
!-- This scenario can be reused for another items as well
Meta:
@001
Given I add four different products to my wish list
When I view my wishlist table
Then I find total four selected items in my wishlist
When I search for lowest price product
And I am able to add lowest price item to my cart
Then I am able to verify the item in my cart