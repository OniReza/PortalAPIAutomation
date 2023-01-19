Feature: API Test For Login

  Background:
    Given A valid csrf token

  Scenario:Verify Login API
    When User hit the end point
    Then User should see status code 401