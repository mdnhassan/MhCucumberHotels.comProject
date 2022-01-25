Feature: Test Hotel.com website sign up functionalities
  Background:
    Given user is on the Hotel.com home page
    When user click on the Sign in button
    And click on Sign Up button


  @SignUpButtonTest
  Scenario: check sign up button is working
    Then user is navigated to the Sign up page

  @PositiveSignUpTest
  Scenario Outline: check sign up functionality for valid data
    And enter Email "<email>", Password"<password>", First name"<firstName>", and Last name"<lastName>"
    And click on Create Account button
    Then user is navigated to the account home page

#    change email address every time you run a test to check valid account creation functionality.
    Examples:
      | email                   | password | firstName | lastName |
      | munni_rahaman@yahoo.com | Mdha842@ | munni     | rahaman  |

  @NegativeSignUpTestInvalidEmail
  Scenario: check sign up functionality with invalid email
    And enter invalid Email Address
    And click on Create Account button
    Then invalid email error message shows up

  @NegativeSignUpTestInvalidPassword
  Scenario: check sign up functionality with invalid password
    And enter invalid Password
    And click on Create Account button
    Then invalid password error message shows up
