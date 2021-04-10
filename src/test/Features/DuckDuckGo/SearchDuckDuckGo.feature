Feature: Test Login Scenarios

  @duckduckgo
  Scenario Outline: Search for a location in DuckDuckGo
    Given John is on the DuckDuckGo Page
    When he searches for the location "<search_location>"
    Then the page should contain results from that location
    Examples:
      | search_location |
      | Bahamas         |
      | Amsterdam       |
