
  Feature: Login to application

    @xyz
    Scenario Outline: Login with valid credentials
      Given open app url
      When Click on SignIN button
      And Put "<Mobile_Number>" and "<otp>"
      Then Scroll the page till end
      Then Verify "<Page>"

      Examples:
      | Mobile_Number | otp | Page|
      |9818533677     | 1111 | Home |


      @xyz1
    Scenario Outline: Login with valid credentials
      Given open app url
      When Click on SignIN button
      And Put from sheetname "<SheetName>" and rownumber <RowNumber>
      Then Scroll the page till end
      Then Verify "<Page>"

      Examples:
      | Mobile_Number | otp | Page|
      |9818533677     | 1111 | Home |
