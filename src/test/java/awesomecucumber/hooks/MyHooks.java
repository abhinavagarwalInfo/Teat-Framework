
package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
//import awesomecucumber.utils.ExtentReport;
import awesomecucumber.utils.DirectoryUtil;
import awesomecucumber.utils.ZipUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.report.AllureReportBuilder;
import ru.yandex.qatools.allure.report.AllureReportBuilderException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static awesomecucumber.constants.FrameworkConstants.*;
import static awesomecucumber.utils.EmailSendUtils.sendEmail;

public class MyHooks {

	private WebDriver driver;
	//private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	Logger log;
	private final TestContext context;
	public static List<String> passedtests = new ArrayList<String>();
	public static List<String> failedtests = new ArrayList<String>();
	public static List<String> skippedtests = new ArrayList<String>();
	public static int Total_Scenarios;

	static DirectoryUtil directoryUtil = new DirectoryUtil();

	/**
	 * Dependency Injection using Pico container
	 */
	public MyHooks(TestContext context) {
		this.context = context;
	}

//	public void setDriver(WebDriver driver){
//		this.driver.set(driver);
//	}
//
//	public WebDriver getDriver(){
//		return this.driver.get();
//	}

//	@BeforeMethod
//	public void configureTest(Method m){
//		System.out.println("Test Case Name : "+m.getName());
//	}

	@Before
	//@BeforeMethod
	public synchronized void before(Scenario scenario) {

		 //ExtentReport.createTest(scenario.getName());

		System.out.println(
				"BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		log = LogManager.getLogger(MyHooks.class);
		log.info("Scenario Name " + scenario.getName() + " Started");
		/*
		 * System.getProperty("browser" -> This is for test execution using Maven
		 * Command Line file
		 */
		/*
		 * Setting Edge browser as default
		 */
//		driver = DriverFactory.initializeDriver(System.getProperty("browser", "edge"));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,BROWSER_FIREFOX));
		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_CHROME));
		//driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_HEADLESS));
		//driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_EDGE));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,BROWSER_OPERA));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,BROWSER_SAFARI));

		context.driver = driver;
	}

	@After
	//@AfterMethod
	public synchronized void after(Scenario scenario) {
		System.out.println(
				"AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		log = LogManager.getLogger(MyHooks.class);
		log.info("Scenario Name " + scenario.getName() + " Ended");

		/* If Scenario fails */
		/* This is for attaching the screenshot in Cucumber report */
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			//Allure.attachment("Failed Screenshot", new ByteArrayInputStream(screenshot));

		}

		// doExtentReportWork(scenario);

		if(scenario.getStatus().toString().equalsIgnoreCase("PASSED")){
			passedtests.add(scenario.getName());
		}
		if(scenario.getStatus().toString().equalsIgnoreCase("FAILED")){
			failedtests.add(scenario.getName());
		}
		if(scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")){
			skippedtests.add(scenario.getName());
		}
		Total_Scenarios = passedtests.size()+failedtests.size()+skippedtests.size();

		//extentReport.flushReports();
		//extent.flush();
		driver.quit();
	}

//	private void doExtentReportWork(Scenario scenario) {
//
//		if (scenario.getStatus().toString().equals("PASSED")) {
//			ExtentLogger.pass("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.pass("<b><i>" + scenario.getStatus().PASSED + "</i></b>");
//		}
//
//		if (scenario.getStatus().toString().equals("SKIPPED")) {
//			ExtentLogger.skip("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.skip("<b><i>" + scenario.getStatus().SKIPPED + "</i></b>");
//		}
//
//		if (scenario.isFailed()) {
//			ExtentLogger.fail("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.fail("<b><i>" + scenario.getStatus().FAILED + "</i></b>");
//		}
//
//	}

//	@BeforeStep
//	public static void beforeStep() {
//		ExtentLogger.pass("<b><i>" + "BEFORE STEP" + "</i></b>");
//	}

	@BeforeAll
	//@BeforeSuite
	public static void beforeAll() {
		//extentReport.initReports();
//		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/extentReport.html"));
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
		System.out.println("This is BeforeAll method ##########");

		// TO DO :
		// Write the code for : Remove the allure-results directory.
		// store file path
		try{
			File file = new File(System.getProperty("user.dir") + "/allure-results");
			// call deleteDirectory function to delete subdirectory and files
			directoryUtil.deleteDirectory(file);
			// delete main GFG folder
			file.delete();
		}catch(Exception e){
			e.printStackTrace();
		}


		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter spark = new ExtentHtmlReporter("target/Spark.html");
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest")
				.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();
	}

	@AfterAll
	//@AfterSuite
	public static void afterAll() {
	//	extentReport.flushReports();
		System.out.println("This is AfterAll method ##########");

//		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//			try {
//				new AllureReportBuilder("1.5.4", new File("/allure-report")).unpackFace();
//			} catch (AllureReportBuilderException e) {
//				throw new RuntimeException(e);
//			}
//			try {
//				new AllureReportBuilder("1.5.4", new File("/allure-report")).processResults(new File("/allure-results"));
//			} catch (AllureReportBuilderException e) {
//				throw new RuntimeException(e);
//			}
//		}));

		// TO DO:
		// Write the code for : Copy the allure-report/history subdirectory to allure-results/history.
		try{
			File sFile = new File(System.getProperty("user.dir") + "/allure-report/history");
			File dFile = new File(System.getProperty("user.dir") + "/allure-results/history");
			directoryUtil.copyDirectory(sFile,dFile);
		}catch (Exception e){
			e.printStackTrace();
		}

//		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//			try {
//				new AllureReportBuilder("2.24.0", new File("C:/Workspace/Webdriver-Framework/allure-report")).unpackFace();
//				System.out.println("####unpackface#####");
//			} catch (AllureReportBuilderException e) {
//				System.out.println("####unpackface E#####");
//				throw new RuntimeException(e);
//			}
//			try {
//				new AllureReportBuilder("1.5.4", new File("C:/Workspace/Webdriver-Framework/allure-report")).processResults(new File("C:/Workspace/Webdriver-Framework/allure-results"));
//				System.out.println("####process#####");
//			} catch (AllureReportBuilderException e) {
//				System.out.println("####process E#####");
//				throw new RuntimeException(e);
//			}
//		}));

		ZipUtils.zip();
		//onGenerateAllureReport genReport = new onGenerateAllureReport();
		//genReport.run();
		sendEmail();
	}

}
