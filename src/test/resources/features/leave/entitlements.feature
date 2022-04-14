Feature: Entitlements

  @pending
  Scenario: Add entitlements
    Given a user with role 'Admin' logs in
    And the admin user finds an active employee
    When the admin user add new leave entitlement
    Then the employee entitlement must get listed correctly
