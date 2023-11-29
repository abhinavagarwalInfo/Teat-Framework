//package awesomecucumber.utils;
//
//import awesomecucumber.factory.DriverFactory;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import org.testng.ITestResult;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//
//import java.io.File;
//import java.io.IOException;
//
//public class ExtentReport {
//    // Create global variable which will be used in all method
//    ExtentReports extent;
//    ExtentTest logger;
//
//    // This code will run before executing any testcase
//    public void initReports() {
////        ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/extentReport   .html"));
////        extent = new ExtentReports();
////        extent.attachReporter(reporter);
//        System.out.println("ExtentReport start*******************");
//        //logger=extent.createTest("LoginTest");
//    }
//
//    // This will run after testcase and it will capture screenshot and add in report
//    public void tearDown(ITestResult result) throws IOException {
////        if(result.getStatus()==ITestResult.FAILURE) {
////            String temp=Utility.getScreenshot(driver);
////            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
////        }
//
//        extent.flush();
// //       driver.quit();
//
//    }
//    public void flushReports(){
//        extent.flush();
//    }
//}
