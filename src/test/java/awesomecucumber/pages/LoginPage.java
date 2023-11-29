package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(className = "sign-in-btn")
    private WebElement loginbutton;

    @FindBy(id = "mobile-number")
    private WebElement mobileNumber;

    @FindBy(id = "mobile-number-verify-btn")
    private WebElement verifyNumberButton;

    @FindBy(id = "otp-first-letter")
    private WebElement fletter;

    @FindBy(id = "otp-second-letter")
    private WebElement sletter;

    @FindBy(id = "otp-third-letter")
    private WebElement tletter;

    @FindBy(id = "otp-fourth-letter")
    private WebElement lletter;

    @FindBy(id = "otp-verify-btn")
    private WebElement verifyOTPButton;

    @FindBy(id = "otp-error")
    private WebElement incorrectOTP;

    @FindBy(id = "continue-watching-text")
    private WebElement cwRail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickForLogin(){
        click(loginbutton);
    }

    public void enterMobNumber(String mobNumber) {
        clearAndSendKeys(mobileNumber, mobNumber);
    }

    public void clickForVerifyNumber(){
        click(verifyNumberButton);
    }

    public void enterOTP(String otp) {
        char[] ch = new char[otp.length()];
        for (int i = 0; i < otp.length(); i++) {
            ch[i] = otp.charAt(i);
        }
        clearAndSendKeys(fletter, String.valueOf(ch[0]));
        clearAndSendKeys(sletter, String.valueOf(ch[0]));
        clearAndSendKeys(tletter, String.valueOf(ch[0]));
        clearAndSendKeys(lletter, String.valueOf(ch[0]));
    }

    public void clickForVerifyOTP(){
        click(verifyOTPButton);
    }

    public void load() {
        driver.get(ConfigLoader.getInstance().getBaseUrl());
    }

    public String getCWRailText(){
        return getElementText(cwRail);
    }
}
