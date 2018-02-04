Feature: Place Order and verify if the order is displayed in Order history
Description : This feature will place the order and verify if the order reference number is displayed in Order History page

Background: User is Logged in
	Given User is on home page
	When User Navigate to Sign in Page
	And User enters Username and Password on Sign in Page
	| username            | password   |
	| someone@example.com | Password123|
	Then User is logged in and is on My Account page

Scenario: Order T-Shirt and verfiy the Order is displayed in Order History page
	Given User clicks on T-SHIRTS tab
	And User clicks on the first displayed T-shirt
	Then T-shirt product page is displayed
	When User clicks on Add to Cart on product page
	Then Product successfully added to your shopping cart message is displayed
	When User clicks on Proceed to checkout
	Then Shopping cart summary page is displayed
	When User clicks on Proceed to checkout on Summary breadcrumb
	And User clicks on Proceed to checkout on Address breadcrumb
	And User agrees to terms and condition on Shipping breadcrumb
	And User clicks on Proceed to checkout on Shipping breadcrumb
	And User clicks on Pay by bank wire on payment breadcrumb
	And User clicks on I confirm my order on Payment breadcrumb 
	Then Order confirmation page along with order reference number is displayed
	When User clicks on Back to orders link
	Then Order History page is displayed
	And User is able to see the ordered product by verifying the reference number
	Then User clicks on Sign out
	And User is logged out