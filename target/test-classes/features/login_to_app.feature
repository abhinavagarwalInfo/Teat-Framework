
  Feature: Login to application

    @xyz
    Scenario Outline: Login with valid credentials
      Given open app url
      When Click on SignIN button
      And Put "<Mobile_Number>" and "<otp>"
      Then Verify "<Page>"
      Examples:
      | Mobile_Number | otp | Page|
      |9818533671     | 1111 | Home |
