Feature: User Management

  Scenario Outline: User logs into the application
    When a user with role '<userRole>' logs in with valid credentials
    Then home page should be displayed according to the '<userRole>'
    Examples: 
      | userRole |
      | Admin    |
      | ESS      |

  Scenario: Admin user allowed to add a new ESS User to the application
    Given a user with role 'Admin' logs in
    And the user adds a new employee without user role
    When the admin user adds a ESS user role to the employee
    And the current user logs out from OrangeHRM
    Then the new user should be able to login to the application
