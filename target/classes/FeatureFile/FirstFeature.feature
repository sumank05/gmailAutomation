Feature: Gmail Login Page
This feature verifies the Login functionality on Gmail website.
 
Scenario Outline: Check that login using Email and Password is working or not
Given I launch Chrome browser and Enter gmail URL
When I Enter <Email> in Email Address and <password> in password field
Then I verify that the gmail inbox page is displayed

Examples:
    | email                       | Password  | 
    | sumankumawat3334@gmail.com  |Sum@432  | 
    | nk.rajsamand@gmail.com      | 15  | 
    | sunilkumawat3334@gmail.com  | -99 | 
     