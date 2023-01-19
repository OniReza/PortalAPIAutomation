Feature: API Test For CRF Token

  Background:
    Given A valid csrf token

  Scenario:Verify CRF token generate
    When User hit the end point
    Then User should see CRF token is generated
