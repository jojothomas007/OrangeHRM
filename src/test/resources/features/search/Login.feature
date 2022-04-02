Feature: Application Login

  Scenario: User logs into the application
    When user logs in with valid credentials
    Then home page should be displayed


#@pending
 # Scenario: User try to logs in with invalid credentials
  #  When user try to login with invalid credential
   # Then error message should be displayed in login screen