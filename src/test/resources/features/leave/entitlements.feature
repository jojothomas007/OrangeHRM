Feature: Entitlements

  @pending
  Scenario: Add entitlements
    Given a user with role 'Admin' logs in
    When the admin user add new leave entitlement
    Then the employee entitlement must get listed correctly
