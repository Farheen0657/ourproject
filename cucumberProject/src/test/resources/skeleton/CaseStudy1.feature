Feature: CaseStudy1 Feature
Scenario: Inorder to add a new product to TestMeApp user has to login as admin and proceed with further steps
When alex logged-in as admin
And he clicked on add new product
And filled all the mandatory details and clicked on add product
Then product is added succesfully 


