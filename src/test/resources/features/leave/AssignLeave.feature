Feature: Assign leave

  @pending
  Scenario: leave balance gets updated correctly on new leave assignment
    Given a user with role 'Admin' logs in
    And the admin user add new leave entitlement
    When the admin user assign leave to a user
    Then the leave balance should get updated correctly for the user
