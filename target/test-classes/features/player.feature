@regression
  Feature: Login to application

    Background:
      Given open app url
      When Click on SignIN button

    @P1 @player
    Scenario Outline: Player KeyBoard Right Arrow button
      And open app url with moview
      When Click on SignIN button on player page
      And Put "<Mobile_Number>" and "<otp>"
      Then User clicks on watch now Button
      Then wait for 5000 milli second
      Then click KeyBoard Right Arrow button on 5 time
      When wait for 5000 milli second
      Examples:
      | Mobile_Number | otp | Page|
      |9818533677     | 1111 | Home |

    @P0 @player
    Scenario Outline: Player KeyBoard Right Arrow button forward and backward
      And open app url with moview
      When Click on SignIN button on player page
      And Put "<Mobile_Number>" and "<otp>"
      Then User clicks on watch now Button
      Then wait for 5000 milli second
      Then verify player forward functionality in streaming
      Then wait for 2000 milli second
      Then verify player backward functionality in streaming
      Examples:
        | Mobile_Number | otp | Page|
        |9818533677     | 1111 | Home |

    @P0 @player
    Scenario Outline: verify content buffering in full screen size when player in pause state for <contentType>
      And open app url with moview
      When Click on SignIN button on player page
      And Put "<Mobile_Number>" and "<otp>"
      Then User clicks on watch now Button
      Then wait for 5000 milli second
      Then click On full screen Button in playerr
      Then click on play pause player controller button
      Examples:
        | Mobile_Number | otp | Page|
        |9818533677     | 1111 | Home |

#  need to add code in this to navigate particual string rail
#    @scrolling
#    Scenario Outline: Scrolling to particular Element
#      And Put "<Mobile_Number>" and "<otp>"
#      Then Scroll the page till element "<rail>"
#      Then Verify "<Page>"
#      Examples:
#        | Mobile_Number | otp  | Page | rail          |
#        | 9818533677    | 1111 | Home | Top 10 Movies |

# need to scroll watch now and perform horizontal scrolling
# need to verify image compare
# fluent wait


