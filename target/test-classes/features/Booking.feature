Feature: Booking Hotels Feature

  Background:
    Given user has already logged in to application
      |username|password|
      |mmtestuser002@gmail.com|password@123|

    @bookings
  Scenario Outline: Booking Hotels scenario with different set of data
    Given user navigates to Booking page
    When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on search button
    And user show hotels list and book
    And user confirm booking
    Then user see the booking details in accounts page

    Examples:
      |SheetName|RowNumber|
      |Booking|0|
    #  |Booking|1|