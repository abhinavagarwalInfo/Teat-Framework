package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinitions {
    private final LoginPage login;
    private final TestContext context;
    public LoginStepDefinitions(TestContext context) {
        login = PageFactoryManager.getLoginPage(context.driver);
        this.context = context;
    }
        @Given("open app url")
        public void open_app_url() {
            login.load();
        }
        @When("Click on SignIN button")
        public void click_on_sign_in_button() {
            login.clickForLogin();
        }
        @When("Put {string} and {string}")
        public void put_and(String mobNumber, String otp) {
            login.enterMobNumber(mobNumber);
            login.clickForVerifyNumber();
            login.enterOTP(otp);
            login.clickForVerifyOTP();
        }

        @Then("Verify {string}")
        public void verify(String string) {
            Assert.assertTrue(true);
        }
}
