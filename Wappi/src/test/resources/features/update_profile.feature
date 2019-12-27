#Author: jorman28@gmail.com
Feature: Update Profile
  I want to update my profile data

  @Successfully
  Scenario Outline: Update Profile Data
    Given that I want to enter the page
      | userName | <userName> |
      | password | <password> |
    When I enter the update profile section
    And I enter the data to modify
      | image          | <image>          |
      | firstName      | <firstName>      |
      | lastName       | <lastName>       |
      | bornDate       | <bornDate>       |
      | country        | <country>        |
      | gender         | <gender>         |
      | expectedResult | <expectedResult> |
    Then I must validate the expected result of the update "<expectedResult>"

    Examples:
      | userName      | password      | image                               | firstName | lastName | bornDate | country        | gender    | expectedResult          |
      ##@externaldata@./src/test/resources/datadriven/DataDriven.xlsx@Profile
      |Administrador|Administrador|C:/Wappi/Wappi/img.jpg|Jorman|Rincón|06/11/1993|Estados Unidos|Masculino|Registrado exitosamente|
