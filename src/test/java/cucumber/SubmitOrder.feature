@tag
Feature: Purchase the order from Ecom Website
	I want to use this template for my feature file

Background:
Given: I landed on Ecom Page

@tag2
Scenario Outline: Positive Test of Submiting the order
Given: Log in with username<name> and password<password>
When: I add product <productName> to cart
And: Checkout <productName> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

Examples:
|name					|Password			|productName|
|kamal123@everest.com	|Rootroot#123		|ZARA COAT 3|
