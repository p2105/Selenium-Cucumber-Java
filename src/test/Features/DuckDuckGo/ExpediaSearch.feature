Feature: Test Login Scenarios

  @expedia
  Scenario: Search for a flight and accommodation
    Given John navigate to the Expedia website
    When John looks for a flight+accommodation from "Brussels" to "New York"
    Then the result page contains travel option for the chosen destination
