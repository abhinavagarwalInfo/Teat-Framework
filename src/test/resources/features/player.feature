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

#  need to add code in this to navigate particual string rail
    @scrolling
    Scenario Outline: Scrolling to particular Element
      And Put "<Mobile_Number>" and "<otp>"
      Then Scroll the page till element "<rail>"
      Then Verify "<Page>"
      Examples:
        | Mobile_Number | otp  | Page | rail          |
        | 9818533677    | 1111 | Home | Top 10 Movies |

# need to scroll watch now and perform horizontal scrolling
# need to verify image compare
# fluent wait


