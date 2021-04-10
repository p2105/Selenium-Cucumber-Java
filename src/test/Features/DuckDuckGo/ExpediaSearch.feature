Feature: Test Login Scenarios

  @expedia @flight_plus_accommodations
  Scenario: Search for a flight and accommodation
    Given John navigate to the Expedia website
    When John looks for a flight+accommodation from "Brussels" to "New York"
    Then the result page contains flight+accommodation option for the chosen destination

  @expedia @flight
  Scenario: Search for a flight
    Given John navigate to the Expedia website
    When John looks for a flight from "BRU" to "JFK"
    Then the result page contains flight option for the chosen destination