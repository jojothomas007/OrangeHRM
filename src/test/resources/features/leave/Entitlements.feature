Feature: Entitlements

  Scenario: Add leave entitlements
 		Given a user with role 'Admin' logs in
    And the admin user finds an active employee
    And the admin user fetch current leave entitlement
    When the admin user add new leave entitlement
    Then the employee entitlement must get listed correctly
