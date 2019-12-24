#Author: jorman28@gmail.com
Feature: Login and sign out
  I want to login in the wappi page

  @Successfully
  Scenario Outline: Login Success
    When I enter my credentials
      | userName | <userName> |
      | password | <password> |
    And I close the session
    Then I validate the sesion closure

    Examples:
      | userName      | password      |
      | Administrador | Administrador |

  @Fail
  Scenario Outline: Login Fail
    When I enter my credentials
      | userName | <userName> |
      | password | <password> |
    Then I validate the login fail

    Examples:
      | userName | password |
      | abcd     | abcd     |
