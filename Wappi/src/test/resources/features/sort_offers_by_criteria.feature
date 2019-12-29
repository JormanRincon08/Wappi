#Author: jorman28@gmail.com
Feature: Sort Offers By Criteria
  I want to sort offers by criteria columns

  @SortOffers
  Scenario Outline: Sort Offers By Criteria
    Given that I want to enter the page
      | userName | <userName> |
      | password | <password> |
    When I click the on the criteria "<criteria>" to be sorted according to the number of clicks <clickQuantity>
    Then verify that the number of clicks <clickQuantity> corresponds to the appropriate sort type "<sortExpected>"

    Examples:
      | userName      | password      | criteria | clickQuantity | sortExpected |
      ##@externaldata@./src/test/resources/datadriven/DataDriven.xlsx@SortOffersByCirteria
      |Administrador|Administrador|Fecha|1|ASC|
      |Administrador|Administrador|Precio|2|DESC|
      |Administrador|Administrador|Comercio|3|ASC|
      |Administrador|Administrador|Fecha|4|ASC|
      |Administrador|Administrador|Precio|5|DESC|
      |Administrador|Administrador|Comercio|6|ASC|
