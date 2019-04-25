Feature: Login Feature
Scenario Outline: Valid User Scenario
Given The URL of TestMeApp
When user enters <username> as username
And user enters <password> as a password
Then user is in <page>

Examples:
|username |password |page |
|Lalitha|Password123|Home |
|admin|Password456 | Admin Home |

@invalid
Scenario: invalid scenario
Given The URL of TestMeApp
Then user enters invalid data
 |abcxyz|Password123|
 |Lalitha|abc123|
 |abc123|abc123|

#Scenario: Valid Admin User Scenario
#Given The URL of TestMeApp
#When user enters "admin" as username
#And user enters "Password456" as a password
Then user is in Login page
|bdc|
|ddc|
|hdc|