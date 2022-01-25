Feature: Test search button on the home page functionality

  @SearchButtonTest
  Scenario Outline: check search functionality is working
    Given user is on the Hotel.com home page
    When user enter destination"<destination>"
    Then click on search button
#    Then user navigated to the result page

    Examples:
      | destination                                     |
      | Dubai, Dubai, United Arab Emirates              |
      | Boston, Massachusetts, United States of America |

