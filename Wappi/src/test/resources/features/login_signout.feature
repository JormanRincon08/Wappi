#Author: jorman28@gmail.com
Feature: Login and sign out
  I want to login in the wappi page

  @Successfully
  Scenario Outline: Login Success
    When I enter my credentials
      | userName | <userName> |
      | password | <password> |
    And I close the session
    Then I validate the session closure

    Examples:
      | userName      | password      |
      | Administrador | Administrador |

  @Fail
  Scenario Outline: Login Fail Username required
    When I enter my credentials
      | userName | <userName> |
      | password | <password> |
    Then I validate the username required login fail with the message "<expectedResult>"

    Examples:
      | userName | password | expectedResult                                   |
      | abcd     | abcd     | El usuario debe contener entre 6 y 20 caracteres |
      |          | abcd     | El usuario debe contener entre 6 y 20 caracteres |
