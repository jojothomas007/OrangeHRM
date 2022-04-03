Feature: Add and List Employees

  
  Scenario: Add new employee with minimum information
    Given a user with role 'Admin' logs in
    When the user adds a new employee with minimum information
    Then the employee must get listed correctly
