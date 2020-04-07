Feature: Login Salesforce

@login
Scenario: Test the salesforce login

	Given User is already on login page
	When Title of login page is salesforce
	Then Enter username and password
		|Fields  |Values                               |
		|Username|alaghunidhi.elangovan@landsend.com.qa|
		|Password|MARmar1@								|

	Then Click on login button

@apex
Scenario: Compile apex classes

	When User is on home page
	Then click setup
	Then Enter Apex in search box
	Then click Apex classes
	Then compile all classes

@triggers
Scenario: Compile apex triggers

	Then Enter the Apex in search box
	Then click Apex trigger
	Then compile all triggers
	Then Display success message
	
