Feature: Assign leave

  Scenario: leave balance gets updated correctly on new leave assignment
    Given a user with role 'Admin' logs in
    And the admin user finds an active employee
    And the admin user add new leave entitlement
    And the admin user fetch current leave information
    When the admin user assign leave to the employee
    Then the employee leave balance must get updated correctly
    