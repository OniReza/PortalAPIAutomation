Feature: Api Test For SignUp

  Background:
    Given A valid csrf token

  Scenario:Verify SignUp API Functionality
    When User hit the end point fo sign up
    Then User should see portal sign up complete


