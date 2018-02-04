Feature: Update Personal Information on My Account Page
Description: This feature will test if user is able to update the Personal Information on My Account page

Scenario Outline: Update First Name in Personal Information on My Account Page
	Given User navigates to home page
	When User clicks on Sign in link
	And User enters "<username>" and "<password>"
	Then User is logged in and My Account page is displayed
	When User click on My Personal Information button
	And User update "<firstname>" with valid allowed name and enter valid "<reenter_password>"
	And User clicks on Save
	Then Your personal information has been successfully updated message is displayed
	When User clicks on Sign out
	And User is logged out
	
Examples:
		| username            | password    | firstname    | reenter_password |
		| someone@example.com | Password123 | changedName  | Password123      |
		| someone@example.com | Password123 | nameChanged  | Password123      |
		| someone@example.com | Password123 | NewName      | Password123      |