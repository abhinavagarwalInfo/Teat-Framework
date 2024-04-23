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
            Assert.assertEquals(login.getURL(),"https://www.airtelxstream.in/");
            Assert.assertEquals(login.getCWRailText(),"Continue Watching");
        }

        @Then("Scroll the page till end")
        public void scrollThePageTillEnd() throws InterruptedException {
            Thread.sleep(5000);
            //login.scrollTo();
            //login.scrollDownByDefiningNumberOfPixels(10,500);
            login.scrollDownToBottom();
            Thread.sleep(5000);
        }

    @When("Put from sheetname {string} and rownumber {int}")
        public void Putfromsheetnameandrownumber(String sheetName, Integer rowNumber) {
            ExcelReader reader = new ExcelReader();
            String sheetPath = System.getProperty("user.dir");
            List<Map<String, String>> testData = reader.getData(sheetPath + "/src/test/resources/PurchaseData.xlsx", sheetName);
            String mobNum = testData.get(rowNumber).get("MobNumber");
            String otp = testData.get(rowNumber).get("OTP");
            login.enterMobNumber(mobNum);
            login.clickForVerifyNumber();
            login.enterOTP(otp);
            login.clickForVerifyOTP();
        }
}
