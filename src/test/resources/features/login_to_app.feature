@regression
  Feature: Login to application

    Background:
      Given open app url
      When Click on SignIN button

    @login
    Scenario Outline: Login with valid credentials
      And Put "<Mobile_Number>" and "<otp>"
      Then Scroll the page till end
      Then Verify "<Page>"
      Examples:
      | Mobile_Number | otp | Page|
      |9818533677     | 1111 | Home |
