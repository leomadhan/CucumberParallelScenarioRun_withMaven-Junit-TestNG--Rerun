Feature: Login

  Scenario: Login with correct credentials
    Given user is on login page
    When user enter username "mmtestuser001@gmail.com"
    And user enter password "password@123"
    And user clicks on login button
    Then user should be all to see their name as "MMM M"
    And user able to access their profile
    And user able to update their profile
      | Fields                 | Values              |
      | Address                | Tom                 |
      | Address 2              | Kenny               |
      | City                   | hosur               |
      | State/ Region          | tn                  |
      | Postal/ Zip Code       | 635109              |
#      | Country                | India               |
      | Phone                  | 1023456789          |
    And user able to access their profile
    And user able to see the changes
      | Fields                 | Values              |
      | Address                | Tom                 |
      | Address 2              | Kenny               |
      | City                   | hosur               |
      | State/ Region          | tn                  |
      | Postal/ Zip Code       | 635109              |
#      | Country                | India               |
      | Phone                  | 1023456789         |