Feature: Test Hotel.com website sign in functionalities

  Background:
    Given user is on the Hotel.com home page
    When user click on the Sign in button

  @SinInButtonTest
  Scenario: check sign in button is working
    Then user is navigated to the Sign in page

  @PositiveSignInTest
  Scenario Outline: check sign in functionality is working with valid credentials
    And enter valid Email address "<Email>" and Password "<Password>"
    And click on Sign in button
    Then user is navigated to the account main home page

    Examples:
      | Email                   | Password  |
      | munni_rahaman@yahoo.com | Mdhas842@ |
  @NegativeSignInTest
  Scenario: check sign in functionality is working with invalid credentials
    And enter invalid Email address and Password
    And click on Sign in button
    Then invalid Email or password error message shows up

  @TripSummeryTest
  Scenario Outline: check your booking activity
    And enter valid Email address "<Email>" and Password "<Password>"
    And click on Sign in button
    And select Trips option
    Then user is navigated to the trip summery page

    Examples:
      | Email                  | Password |
      | mdnhassan842@gmail.com | Mdha842@ |




