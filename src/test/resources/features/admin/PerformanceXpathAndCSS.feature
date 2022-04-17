Feature: Performance of Xpath and CSS locators

  Scenario: Read all elements of user table using xpath and CSS 
    Given a user with role 'Admin' logs in
    Then print all user details using xpath and CSS
