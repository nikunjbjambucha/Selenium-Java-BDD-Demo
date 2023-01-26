Feature: Add Customers to XYZ bank
	
	@StartBrowser
    Scenario:  Initialize browser
		Given Browser is opened
	
	Scenario Outline: Add customer and verify alert message
    	Given User Navigate to Add customer Page
    	And User enters "<Fname>" "<Lname>" and "<Pcode>"
	  	Then Message displayed Customer added Successfully

	Examples: 
      | Fname  | Lname | Pcode  |
      | UserFname1 | UserLname1 | 60020 |
      | UserFname2 | UserLname2 | 60021 |
      