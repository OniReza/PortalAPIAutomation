Feature: API Test For CRF Token

  Background:
    Given A valid csrf token

  Scenario:Verify CRF token generate
    When User hit the end point
    Then The response code should 200

#  Scenario:Verify testCRF token generate
#    When User hit the end point "v2/auth/onboarding/signup"
#    Then User choose "Us"


