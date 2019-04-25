Feature: Shout Feature
Scenario: Sean Shouts
Given Sean is 10 meters away from Lucia
When Sean shouts "Free Coffee"
Then Lucia "listens" to the message

Scenario: Sean Shouts away from Lucia
    Given sean is 200 meters away from Lucia
    When Sean shouts "Free Coffee"
    Then Lucia "cannot listens" to the message
