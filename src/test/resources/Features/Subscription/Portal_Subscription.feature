Feature: Api Test For Subscription

  Background:
    Given A valid csrf token

  Scenario:Verify Subscription API Functionality
    When User hit the end point for portal subscription
    Then User should see portal subscription complete successfully