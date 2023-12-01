
package awesomecucumber.runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(
		plugin = { 
				"html:target/cucumber/cucumber.html" ,
				"me.jvt.cucumber.report.PrettyReports:target/cucumber/",
				"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failedrerun.txt"
		}, 
		glue = {"awesomecucumber"},
		// glue = {"awesomecucumber.stepdefinitions","awesomecucumber.hooks"},
		features = {"src/test/resources/features"},
		tags = "@smoke",
		monochrome = true)
		//tags = "@regression")
		//tags = "@demo")
@Test
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

	/**
	 * https://cucumber.io/docs/guides/parallel-execution/#testng
	 * 
	 * Cucumber can be executed in parallel using TestNG and Maven test execution
	 * plugins by setting the dataprovider parallel option to true.
	 * 
	 * In TestNG the scenarios and rows in a scenario outline are executed in
	 * multiple threads. One can use either Maven Surefire or Failsafe plugin for
	 * executing the runners.
	 **/

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
//
//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("================ BEFORE SUITE ================");
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("================ AFTER SUITE ================");
//	}
}
