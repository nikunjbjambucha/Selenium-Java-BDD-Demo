Feature: Add Customers to XYZ bank

	Scenario Outline: Add customer and verify alert message
    	Given Browser is opened
    	When User Navigate to Add customer Page
    	And User enters "<Fname>" "<Lname>" and "<Pcode>"
	  	Then Message displayed Customer added Successfully and close the browser

	Examples: 
      | Fname  | Lname | Pcode  |
      | UserFname1 | UserLname1 | 60020 |
      | UserFname2 | UserLname2 | 60021 |
      | UserFname3 | UserLname3 | 60021 |
      | UserFname4 | UserLname4 | 60020 |
      | UserFname5 | UserLname5 | 60021 |
      