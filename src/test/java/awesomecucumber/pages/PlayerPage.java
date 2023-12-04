package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import freemarker.core.ParseException;
import groovyjarjarasm.asm.Handle;
import io.cucumber.java.en.Then;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;
import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.seconds;

public class PlayerPage extends BasePage{

    private static long DEFAULT_FIND_ELEMENT_TIMEOUT;
    @FindBy(xpath = "//p[contains(text(),'Login to watch')]")
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

    @FindBy(xpath = "//span[normalize-space()='Top 10 Movies']")
    private WebElement top10Movies;
    @FindBy(id = "seekbar-current-time")
    private WebElement seekbar_current_time_labell;
    @FindBy(id = "seekbar-current-time")
    private WebElement seekbar_end_time_labell;


    public PlayerPage(WebDriver driver) {
        super(driver);
    }
    public boolean loading() throws InterruptedException {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + "movies/laboratory-hindi/HOICHOI_MOVIE_14046aaa-9648-4cc8-8b39-cb2e5df29ce0");
        String url = driver.getCurrentUrl();
        System.out.println("url>>"+url);
        Assert.assertTrue(url.contains("airtelxstream"));
        driver.navigate().refresh();
        Thread.sleep(10000);
        return true;
    }

    public void clickForLogin(){
        click(loginbutton);
    }
    private By watchNowBtn = By.xpath("//button[@id='play-content-button']");
    public void clickOnwatchNowBtn() {
        sleep(5000);
        click(watchNowBtn);
    }
    private By videoPlayer = By.xpath("//div[@class='vdo-player']");
    private By play_pause_bottom_controls = By.id("player-play-btn");
    public void click_on_play_pause_bottom_control_button() {
        mouse_Hover(videoPlayer, true);
        click(play_pause_bottom_controls);
    }
    public By seekbar_current_time_label = By.id("seekbar-current-time");

    public String getCWText() {
        System.out.println("cwText>>"+getElementText(seekbar_current_time_labell));
        return getElementText(seekbar_current_time_labell);
    }
    public String get_player_Thumb_Current_Timee() {
//        sleep(5000);
        mouse_Hover(videoPlayer, true);
        System.out.println("getText(seekbar_current_time_label)>>>>>>>"+ getElementText(seekbar_current_time_labell));
        return getElementText(seekbar_current_time_labell);
    }
    //    public String getText(By locator, long... waitSeconds) {
//        WebElement we = this.getElementText(locator);
//        WebElement we = this.getElementText(WebElement);
//        return we == null ? null : we.getText();
//        return null;
//    }
    public int time_to_milliSec(String time) {
        String hours = StringUtils.substringBefore(time, ":");
        String second = StringUtils.substringAfterLast(time, ":");
        String min = StringUtils.substringBetween(time, hours + ":", ":" + second);
        return (Integer.parseInt(hours) * 60 * 60 * 1000) + (Integer.parseInt(min) * 60 * 1000) + (Integer.parseInt(second) * 1000);

    }
    private By seek_Bar = By.xpath("//div[@id='seekbar']");
    public void click_ON_LeftArrow_respect_of_seekBar() {
        mouse_Hover(videoPlayer, true);
//        getDriver().findElement(seek_Bar).sendKeys(Keys.ARROW_LEFT);
        driver.findElement(seek_Bar).sendKeys(Keys.ARROW_LEFT);
    }
    private By forward_btn = By.id("player-forward-btn");
    public void click_ON_RightArrow_respect_of_seekBar() {

//        commonPage.mouse_Hover(seek_Bar, false);
//        getDriver().findElement(seek_Bar).sendKeys(Keys.ARROW_RIGHT);
        //commonPage.mouse_Hover_click(forward_btn);

        Actions action = new Actions(driver);
        mouse_Hover(videoPlayer, true);
        WebElement fwd = driver.findElement(forward_btn);
        action.moveToElement(fwd).perform();
        mouse_Hover(videoPlayer, true);
        fwd.click();
    }
    public String get_player_Thumb_Current_Time() {
//        sleep(5000);
        mouse_Hover(videoPlayer, true);
        System.out.println("getText(seekbar_current_time_label)>>>>>>>"+ getElementText(seekbar_current_time_labell));
        return getElementText(seekbar_current_time_labell);
    }
    private By seekbar_end_time_label = By.id("seekbar-end-time");
//public String get_player_Thumb_End_Time() {
//    sleep(5000);
//    mouse_Hover(videoPlayer, true);
//    return getText(By.id(String.valueOf(seekbar_end_time_label)));
//}

    public String get_player_Thumb_End_Time() {
        sleep(5000);
        mouse_Hover(videoPlayer, true);
        return getElementText(seekbar_end_time_labell);
    }
    private By seekbar_Thumb = By.xpath("//div[@class='thumb']");
    public void set_SeekBar_Thumb_In_Start() {

        sleep(5000);

        while (time_to_milliSec(get_player_Thumb_Current_Time()) > (time_to_milliSec(get_player_Thumb_End_Time()) * 96) / 100) {
            click_ON_LeftArrow_respect_of_seekBar();
        }

        while (time_to_milliSec(get_player_Thumb_Current_Time()) < (time_to_milliSec(get_player_Thumb_End_Time()) * 4) / 100) {
            click_ON_RightArrow_respect_of_seekBar();
        }

        new Actions(driver)
                .clickAndHold(driver.findElement(seekbar_Thumb))
                .moveToElement(driver.findElement(seekbar_current_time_label))
                .release().perform();

    }
//    public String getText(By locator, long... waitSeconds) {
//        WebElement we = this.getElementWhenVisible(locator, waitSeconds);
//        return we == null ? null : we.getText();
//    }
//    public WebElement getElementWhenVisible(By locater, long... waitSeconds) {
//        assert waitSeconds.length <= 1;
//
//        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;
//        WebElement element = null;
////        this.waitForJStoLoad();
//        long minTime =  20L;
//        if (seconds <= minTime) {
//            minTime = (long)((int)(seconds / 2L));
//        }
//
////        Handle handle = new Handle(this.Environment, this.Reporter, this.Assert, this.SoftAssert, this.sTestDetails);
////        WebDriverWait wait = new WebDriverWait(driver, Clock.systemDefaultZone(), minTime * 1000L);
//        long implicitWait = Long.valueOf(((driver.HashMapNew).get("implicitWait")) / 1000L;
//        long impliciWait = Long.valueOf(driver.hashCode
//
//        try {
//            this.driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
//            element = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
//        } catch (Exception var16) {
//            this.performActionsOnSetOfExceptions(var16);
//            throw var16;
//        } finally {
////            this.getDriver().manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
//            this.driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
//        }
//
//        return element;
//    }

    public boolean verify_streaming_is_working() {
        sleep(5000);
        String currentTime = get_player_Thumb_Current_Time();
        sleep(5000);
        String TimeafterTwoSec = get_player_Thumb_Current_Time();
        System.out.println("current time" + currentTime + "****" + "time after 2 sec" + TimeafterTwoSec);
        if (currentTime.equals(TimeafterTwoSec)) {
            System.out.println("return false");
            return false;
        } else {
            System.out.println("return true");
            return true;
        }
    }
    public int verify_forward_button_functionality() throws ParseException, java.text.ParseException {
        sleep(5000);
        mouse_Hover(videoPlayer, false);
//        String currentTime = getText(seekbar_current_time_label);
        String currentTime = getElementText(seekbar_current_time_labell);
        System.out.println(currentTime);
        click_On_Forward_Button();

        mouse_Hover(videoPlayer, false);
//        String currentTime2 = getText(seekbar_current_time_label);
        String currentTime2 = getElementText(seekbar_current_time_labell);
        System.out.println(currentTime2);
        return get_Time_diff_in_Sec(currentTime, currentTime2);
    }

    public int verify_backward_button_functionality() throws ParseException, java.text.ParseException {
        //  String currentTime = get_player_Thumb_Current_Time();
        mouse_Hover(videoPlayer, false);
        String currentTime = getElementText(seekbar_current_time_labell);
        click_On_BackWard_Button();
        //    String currentTime2 = get_player_Thumb_Current_Time();
        mouse_Hover(videoPlayer, false);
        String currentTime2 = getElementText(seekbar_current_time_labell);
        return get_Time_diff_in_Sec(currentTime, currentTime2);
    }
    public int get_Time_diff_in_Sec(String time1, String time2) throws ParseException, java.text.ParseException {
        SimpleDateFormat simpleformat = new SimpleDateFormat("HH:mm:ss");
        return Math.abs(Seconds.secondsBetween(new DateTime(simpleformat.parse(time1)), new DateTime(simpleformat.parse(time2))).getSeconds() % 60);
    }
    private By backward_btn = By.id("player-backward-btn");
    public void click_On_BackWard_Button() {
        mouse_Hover(videoPlayer, true);
        click(backward_btn);

    }
    public void mouse_Hover(By locator, boolean iterationFlag) {
        int count = 0;
        if (iterationFlag) {
            while (count <= 5)
                try {
                    new Actions(driver).moveToElement(driver.findElement(locator)).perform();
//                    new Actions(driver).moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator))).build().perform();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    count++;
                }
        } else {
            new Actions(driver).moveToElement(driver.findElement(locator)).perform();
        }

    }
    public void click_On_Forward_Button() {
        mouse_Hover(videoPlayer, true);
        click(forward_btn);
    }
    public void sleep(int sTime) {
        try {
            Thread.sleep((long)sTime);
        } catch (InterruptedException var3) {
//            log.info("Threw a Exception in BaseUtil::sync, full stack trace follows:", var3);
        }

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

//    public boolean load() {
//        driver.get(ConfigLoader.getInstance().getBaseUrl());
//        String url = driver.getCurrentUrl();
//        Assert.assertTrue(url.contains("airtelxstream"));
//        return true;
//    }

    public String getCWRailText(){
        return getElementText(cwRail);
    }

//    public void scrollTo{
////        waitForElementVisibility(rail);
//        scrollToElement();
//        waitForElementVisibility(top10Movies);
//    }

//    public void scrollToElement(String rail){
////        waitForElementVisibility(rail);
//        scrollToElement(rail);
//        waitForElementVisibility(top10Movies);
//    }

//    public void scrollToelement(String rail) {
//        scrollToElement(rail);
//        waitForElementVisibility(top10Movies);
//    }

    public void scrollTo(){
        scrollToElement(top10Movies);
    }
    //    private By play_pause_bottom_controls = By.id("player-play-btn");
    public void clickOnPlayPausePlayerControlBtn() {
        mouse_Hover(videoPlayer, true);
        click(play_pause_bottom_controls);
    }
    private By toggle_full_screen_btn = By.xpath("//button[@id='atm_player-toggle-fullscreen']");
    public void click_On_full_screen_Buttonn() {
//        if(!verifyPlayback()){
//            click_on_play_pause_bottom_control_button();
//            sleep(50);
//        }
        mouse_Hover(videoPlayer, true);
        click(toggle_full_screen_btn);
//        Thread.sleep(5000);
//        new Actions(getDriver()).moveToElement(new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(toggle_full_screen_btn))).click().build().perform();
    }
}