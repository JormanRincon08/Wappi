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
