package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LoginPage;
import awesomecucumber.pages.PlayerPage;
import freemarker.core.ParseException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PlayerStepDefinitions {
    private final PlayerPage player;
    private final TestContext context;
    public PlayerStepDefinitions(TestContext context) {
        player = PageFactoryManager.getPlayerPage(context.driver);
        this.context = context;
    }
    @And("open app url with moview")
    public void open_app_url() throws InterruptedException {
//            login.load();
        Assert.assertTrue(player.loading());
    }
    @When("Click on SignIN button on player page")
    public void click_on_sign_in_button() {
        player.clickForLogin();
    }

    @Then("User clicks on watch now Button")
    public void user_clicks_on_watch_now_Button() {
        player.clickOnwatchNowBtn();
    }

    @Then("^wait for (.+) milli second$")
    public void clickOnVolumeButton(String millisecond) {
        player.sleep(Integer.parseInt(millisecond));
    }

    @When("^set seekBar Thumb in start$")
    public void set_seekBar_Thumb_in_start() {
//        playerPage.waitStillVideoLoad();
        player.sleep(20);
        if (!player.verify_streaming_is_working())
            player.sleep(20);
        player.click_on_play_pause_bottom_control_button();
        player.sleep(20);
        player.set_SeekBar_Thumb_In_Start();
    }
    @Then("^click On full screen Button in playerr$")
    public void click_On_full_screen_Buttonn() {
        player.click_On_full_screen_Buttonn();
    }
    @Then("click on play pause player controller button")
    public void click_on_play_pause_player_controller_button() {
        player.clickOnPlayPausePlayerControlBtn();
    }
    @Then("^verify player forward functionality in streaming$")
    public void verify_player_forward_func_in_Streaming() throws ParseException, java.text.ParseException {
        click_On_Keyboard_RightArrow_Button("4");
    }
    @And("click KeyBoard Left Arrow button on (.+) time$")
    public void click_On_Keyboard_LeftArrow_Button(String noOfTime) throws ParseException {
        for (int i = 1; i <= Integer.parseInt(noOfTime); i++) {
            player.click_ON_LeftArrow_respect_of_seekBar();
            player.sleep(20);

        }
    }
    @Then("^verify player backward functionality in streaming$")
    public void verify_player_backward_func_in_Streaming() throws ParseException, java.text.ParseException {
        player.set_SeekBar_Thumb_In_Start();
        click_On_Keyboard_LeftArrow_Button("4");
        player.sleep(10);

    }
    //    @Then("^verify player backward functionality in streaming$")
//    public void verify_player_backward_func_in_Streaming() throws ParseException {
//        player.set_SeekBar_Thumb_In_End();
//        click_On_Keyboard_LeftArrow_Button("4");
//        player.sleep(10);
//        int backwardTime = player.verify_backward_button_functionality();
//        System.out.println("verify player backward functionality in streaming " + backwardTime);
//
//        if (backwardTime == 10 || backwardTime == 9 || backwardTime == 11 || backwardTime == 8) {
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertTrue(false, " after click on backward button time gab is not 10 ,9 ,8 ,7 sec");
//        }
//
//    }
    @And("click KeyBoard Right Arrow button on (.+) time$")
    public void click_On_Keyboard_RightArrow_Button(String noOfTime) {
        for (int i = 1; i <= Integer.parseInt(noOfTime); i++) {
            player.click_ON_RightArrow_respect_of_seekBar();
            player.sleep(20);
        }
    }
//        @When("Put {string} and {string}")
//        public void put_and(String mobNumber, String otp) {
//            login.enterMobNumber(mobNumber);
//            login.clickForVerifyNumber();
//            login.enterOTP(otp);
//            login.clickForVerifyOTP();
//        }
//
//        @Then("Verify {string}")
//        public void verify(String string) {
//            Assert.assertEquals(login.getURL(),"https://www.airtelxstream.in/");
//            Assert.assertEquals(login.getCWRailText(),"Continue Watching");
//        }
//
//        @Then("Scroll the page till end")
//        public void scrollThePageTillEnd() throws InterruptedException {
//            Thread.sleep(5000);
//            login.scrollDownToBottom();
//            Thread.sleep(5000);
//        }
//
//    @Then("Scroll the page till element {string}")
//    public void scrollThePageTillElement(String rail) throws InterruptedException {
//        Thread.sleep(5000);
////        login.scrollToElement(Top 10 Movies);
////        login.waitForTextToBePresentInElement();
//        login.scrollTo();
//        Thread.sleep(5000);
//    }
}

