package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"@target/failedrerun.txt"}, glue = {"awesomecucumber"},
        plugin = {"html:target/cucumber/cucumber.html" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber/",
                "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class FailedRunnerTests extends AbstractTestNGCucumberTests {

}
