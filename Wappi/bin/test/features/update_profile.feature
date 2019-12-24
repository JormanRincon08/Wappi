#Author: jorman28@gmail.com
#Feature: Create An Account
  #I want to register on the page to make purchases
#
  #@Successfully
  #Scenario Outline: Successful User Registration
    #Given that I want to enter the registration section
    #When enter the email "<email>" to register
    #And I enter my personal information
      #| title            | <title>            |
      #| firstName        | <firstName>        |
      #| lastName         | <lastName>         |
      #| email            | <email>            |
      #| password         | <password>         |
      #| dateOfBirthDay   | <dateOfBirthDay>   |
      #| dateOfBirthMonth | <dateOfBirthMonth> |
      #| dateOfBirthYear  | <dateOfBirthYear>  |
      #| signNewsletter   | <signNewsletter>   |
      #| receiveOffers    | <receiveOffers>    |
    #And enter my address information
      #| firstNameAddress      | <firstNameAddress>      |
      #| lastNameAddress       | <lastNameAddress>       |
      #| company               | <company>               |
      #| address               | <address>               |
      #| address2              | <address2>              |
      #| city                  | <city>                  |
      #| state                 | <state>                 |
      #| zipPostalCode         | <zipPostalCode>         |
      #| country               | <country>               |
      #| additionalInformation | <additionalInformation> |
      #| homePhone             | <homePhone>             |
      #| mobilePhone           | <mobilePhone>           |
      #| addressAlias          | <addressAlias>          |
    #Then I must validate the expected result "<expectedResult>"
#
    #Examples: 
      #| title | firstName | lastName | email              | password | dateOfBirthDay | dateOfBirthMonth | dateOfBirthYear | signNewsletter | receiveOffers | firstNameAddress | lastNameAddress | company    | address         | address2 | city  | state   | zipPostalCode | country       | additionalInformation                     | homePhone | mobilePhone | addressAlias       | expectedResult |
      ##@externaldata@./src/test/resources/datadriven/CreateAnAccount.xlsx@UserRegister
      #| Mr.   | Jorman    | Rincón   | jorman@dominio.com | Jorman06 |              6 | November         |            1993 | check          | uncheck       | Jorman           | Rincón          | Compañía A | Calle 50 #85-20 |          | Miami | Florida |           123 | United States | Esta es una prueba de registro de usuario |   3775253 |  3156985656 | Dirección de Miami | My account     |
#
  #@Fail
  #Scenario Outline: Fail Login
    #Given that I want to enter the registration section
    #When enter the email "<email>" to register
    #Then I must validate the error expected result "<expectedFailResult>"
#
    #Examples: 
      #| email              | expectedFailResult                                                                                                   |
      #| jorman@dominio.com | An account using this email address has already been registered. Please enter a valid password or request a new one. |
