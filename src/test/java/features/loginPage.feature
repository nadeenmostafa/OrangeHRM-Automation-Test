


    Feature: Test admin login, adding and removing a record functionalities
      @AdminLogin
      Scenario Outline: Login with valid admin credentials and check the addition of a record and its removal
        Given The user logins as admin
        When  The user fills in valid username "<userName>" and password "<password>"
        And   Click login button
        Then  The user is navigated to home page
        And   Clicks on admin button on the sidebar
        And   The user gets the number of current records
        And   Clicks to add a new record
        And   Enter the userRole "<userRole>" and employeeInitial "<employeeInitial>" and status "<status>" and userName "<useName>" and password "<password>" and confirmationPassword "<confirmationPassword>"
        And   Clicks on save button
        And   Gets the number of records again
        Then  The number of records is increased by one
        Then  The user enters the userName "<useName>" and userRole "<userRole>" and status "<status>" for search
        And   Clicks on search button
        Then  The record of the user with specified data should appear
        Then  Click on delete button
        And   Confirm deletion
        Then  Click reset button
        And   Get the number of records
        Examples:
          | userName | password | userRole | employeeInitial| status  | confirmationPassword| useName    |
          | Admin    | admin123 |   ESS    |    a           | Enabled |   admin123          | acdefb1    |







