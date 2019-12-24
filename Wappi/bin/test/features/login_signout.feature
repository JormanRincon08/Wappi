#Author: jorman28@gmail.com
Feature: Login and sign out
  I want to login in the wappi page

  @Successfully
  Scenario Outline: Login Success
    Given I want to login to the page
    When I enter my credentials
      | user     | <user>     |
      | password | <password> |
    And I close the session
    Then I validate the sesion closure

    Examples: 
      | user          | password      |
      | Administrador | Administrador |

  @Fail
  Scenario Outline: Login Fail
    Given I want to login to the page
    When I enter my credentials
      | user     | <user>     |
      | password | <password> |
    Then I validate the login fail

    Examples: 
      | user | password |
      | abcd | abcd     |
