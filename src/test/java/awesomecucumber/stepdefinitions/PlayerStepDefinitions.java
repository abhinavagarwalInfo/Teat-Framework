package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LoginPage;
import awesomecucumber.pages.PlayerPage;
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
//        @Given("open app url")
//        public void open_app_url() {
////            login.load();
//            Assert.assertTrue(login.load());
//        }
//        @When("Click on SignIN button")
//        public void click_on_sign_in_button() {
//            login.clickForLogin();
//        }
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
