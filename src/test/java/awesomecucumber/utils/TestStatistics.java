package awesomecucumber.utils;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import java.util.ArrayList;
import java.util.List;

public class TestStatistics implements ITestListener {

    List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
    List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
    List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();

    @Override

    //This method will automatically be called if a test runs successfully
    public void onTestSuccess(ITestResult result) {
        //add the passed tests to the passed list
        passedtests.add(result.getMethod());
    }

    @Override

    //This method will automatically be called if a test fails
    public void onTestFailure(ITestResult result) {
        //add the failed tests to the failed list
        failedtests.add(result.getMethod());
        System.out.println("Total Passed Test Cases " + failedtests.size());
    }

    @Override

    //This method will automatically be called if a test is skipped
    public void onTestSkipped(ITestResult result) {
        //add the skipped tests to the skipped list
        skippedtests.add(result.getMethod());
        System.out.println("Total Passed Test Cases " + skippedtests.size());
    }

    public int getPassCount(){
        System.out.println("Total Passed Test Cases " + passedtests.size());
        return passedtests.size();
    }

    public int getFailCount(){
        System.out.println("Total Failed Test Cases " + failedtests.size());
        return passedtests.size();
    }

    public int getSkipCount(){
        System.out.println("Total Skipped Test Cases " + skippedtests.size());
        return passedtests.size();
    }
}

