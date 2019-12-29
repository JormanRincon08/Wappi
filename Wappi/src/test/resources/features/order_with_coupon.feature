#Author: jorman28@gmail.com
Feature: Order With Coupon
  I want to get a coupon to place an order

  @Successfully
  Scenario Outline: Successfully Order With Coupon
    Given that I want to enter the page
      | userName | <userName> |
      | password | <password> |
    When I get the welcome coupon code
    And I place an "<offer>" order with the discount code
    Then I value that the order has been correctly executed "<expectedResult>"

    Examples:
      | userName      | password      | offer      | expectedResult              |
      ##@externaldata@./src/test/resources/datadriven/DataDriven.xlsx@OrderWithCoupon
      |Administrador|Administrador|Pan tajado|ha sido utilizado con éxito|

