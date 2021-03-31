Feature: Test Login Scenarios

  @sanity @module_login
  Scenario Outline: Check positive and negative Login scenarios
    Given John is on the Login Page
    When he enters the "<user_id>" and "<password>"
    Then login should be "<login_result>"
    Examples:
      | user_id | password       | login_result |
      | Gavhane | wrong password | unsuccessful |
      | Gavhane | prash_333      | successful   |
