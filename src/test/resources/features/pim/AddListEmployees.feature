Feature: Add and List Employees

  
  Scenario: Add new employee with login details
    Given a user with role 'Admin' logs in
    When the user adds a new employee with login details
    Then the employee must get listed correctly
