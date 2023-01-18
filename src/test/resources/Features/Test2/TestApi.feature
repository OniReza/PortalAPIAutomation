Feature: Customer API Testing

  Scenario: Calling login API
    Given Login API is provided
    When User call login API
    Then a token will be generated
