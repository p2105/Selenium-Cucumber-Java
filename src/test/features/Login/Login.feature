Feature: Test Login Scenarios

  @sanity1 @module_login
  Scenario Outline: Check positive and negative Login scenarios 1
    Given John is on the Login Page
    When he enters the "<user_id>" and "<password>"
    Then login should be "<login_result>"
    Examples:
      | user_id | password  | login_result |
      | Gavhane | prash_331 | unsuccessful |
      | Gavhane | prash_333 | successful   |
#
#  @sanity2 @module_login
#  Scenario Outline: Check positive and negative Login scenarios 2
#    Given John is on the Login Page
#    When he enters the "<user_id>" and "<password>"
#    Then login should be "<login_result>"
#    Examples:
#      | user_id | password  | login_result |
#      | Gavhane | prash_331 | unsuccessful |
#      | Gavhane | prash_333 | successful   |
